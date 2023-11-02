# Initial Setup
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

from sklearn.linear_model import LinearRegression
from sklearn.pipeline import Pipeline
from sklearn.preprocessing import PolynomialFeatures, OneHotEncoder, OrdinalEncoder
from sklearn.metrics import mean_squared_error
from sklearn.model_selection import train_test_split
from sklearn.compose import make_column_transformer, make_column_selector
from sklearn import set_config

# setting this will display your pipelines as seen above
set_config(display="diagram")

# Training data and also information
train = pd.read_csv('data/train.csv')
test = pd.read_csv('data/test.csv')
train.info()
train.head()

# Train/Test Split
X_train, X_test, y_train, y_test = '', '', '', ''
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.3, random_state=22)

# BaseLine Predictions
baseline_train = np.ones(shape=y_train.shape)*y_train.mean()
baseline_test = np.ones(shape=y_test.shape)*y_test.mean()
mse_baseline_train = mean_squared_error(baseline_train, y_train)
mse_baseline_test = mean_squared_error(baseline_test, y_test)

# Examining Correlations
highest_corr = train.corr()[['SalePrice']].nlargest(
    columns='SalePrice', n=2).index[1]


#  Simple Model Usage
X1 = X_train[['OverallQual']]
lr = LinearRegression().fit(X1, y_train)
model_1_train_mse = mean_squared_error(y_train, lr.predict(X1))
model_1_test_mse = mean_squared_error(
    y_test, lr.predict(X_test[['OverallQual']]))


#  OneHotEncoding
# extract the features
central_air_train = X_train[['CentralAir']]
central_air_test = X_test[['CentralAir']]

# Instantiate a OHE object
# sparse = False returns an array so we can view
ohe = OneHotEncoder(sparse=False, drop='if_binary')
print(ohe.fit_transform(central_air_train)[:5])

model_2_train = ohe.fit_transform(central_air_train)
model_2_test = ohe.transform(central_air_test)

model_2 = LinearRegression().fit(model_2_train, y_train)

#  Using make_colum_transformer
col_transformer = make_column_transformer((OneHotEncoder(drop='if_binary'), ['CentralAir']),
                                          remainder='passthrough')

col_transformer.fit_transform(X_train[['OverallQual', 'CentralAir']])
pipe_1 = Pipeline([('col_transformer', col_transformer),
                  ('linreg', LinearRegression())])
pipe_1.fit(X_train[['OverallQual', 'CentralAir']], y_train)

#  Using OrdinalEncoder
oe = OrdinalEncoder(categories=[['Po', 'Fa', 'TA', 'Gd', 'Ex']])
oe.fit_transform(X_train[['HeatingQC']])
X_train['HeatingQC'].head()
ordinal_ohe_transformer = make_column_transformer((OneHotEncoder(drop='if_binary'), ['CentralAir']),
                                                  (OrdinalEncoder(categories=[
                                                   ['Po', 'Fa', 'TA', 'Gd', 'Ex']]), ['HeatingQC']),
                                                  remainder='passthrough')
ordinal_ohe_transformer.fit_transform(
    X_train[['OverallQual', 'CentralAir', 'HeatingQC']])[:5]
X_train[['OverallQual', 'CentralAir', 'HeatingQC']].head()

pipe_2 = Pipeline([('transformer', ordinal_ohe_transformer),
                  ('linreg', LinearRegression())])
pipe_2.fit(X_train[['OverallQual', 'CentralAir', 'HeatingQC']], y_train)
pred_train = pipe_2.predict(
    X_train[['OverallQual', 'CentralAir', 'HeatingQC']])
pred_test = pipe_2.predict(X_test[['OverallQual', 'CentralAir', 'HeatingQC']])
pipe_2_train_mse = mean_squared_error(y_train, pred_train)
pipe_2_test_mse = mean_squared_error(y_test, pred_test)

# Including PolynomialFeatures
poly_ordinal_ohe = make_column_transformer((OrdinalEncoder(categories=[['Po', 'Fa', 'TA', 'Gd', 'Ex']]), ['HeatingQC']),
                                           (OneHotEncoder(drop='if_binary'),
                                            ['CentralAir']),
                                           (PolynomialFeatures(include_bias=False, degree=2), ['OverallQual']))
pipe_3 = Pipeline([('transformer', poly_ordinal_ohe),
                  ('linreg', LinearRegression())])

pipe_3.fit(X_train[['OverallQual', 'CentralAir', 'HeatingQC']], y_train)

quad_train_preds = pipe_3.predict(
    X_train[['OverallQual', 'CentralAir', 'HeatingQC']])
quad_test_preds = pipe_3.predict(
    X_test[['OverallQual', 'CentralAir', 'HeatingQC']])
quad_train_mse = mean_squared_error(y_train, quad_train_preds)
quad_test_mse = mean_squared_error(y_test, quad_test_preds)

# Including more features
features = ['CentralAir', 'HeatingQC', 'OverallQual',
            'GrLivArea', 'KitchenQual', 'FullBath']
X_train[features].head()
poly_ordinal_ohe = make_column_transformer((PolynomialFeatures(), make_column_selector(dtype_include=np.number)),
                                           (OrdinalEncoder(categories=[['Po', 'Fa', 'TA', 'Gd', 'Ex']]), [
                                            'HeatingQC', 'KitchenQual']),
                                           (OneHotEncoder(drop='if_binary', sparse=False), ['CentralAir']))


train_mses = []
test_mses = []
# for degree in 1 - 5
for i in range(1, 6):
    # create pipeline with PolynomialFeatures degree i
    poly_ordinal_ohe = make_column_transformer((PolynomialFeatures(degree=i), make_column_selector(dtype_include=np.number)),
                                               (OrdinalEncoder(categories=[
                                                ['Po', 'Fa', 'TA', 'Gd', 'Ex']]), ['HeatingQC']),
                                               (OneHotEncoder(drop='if_binary'), ['CentralAir']))
    pipe = Pipeline([('transformer', poly_ordinal_ohe),
                    ('linreg', LinearRegression())])

    pipe.fit(X_train[features], y_train)
    # fit on train
    p1 = pipe.predict(X_train[features])
    p2 = pipe.predict(X_test[features])
    # predict on train and test
    train_mses.append(mean_squared_error(y_train, p1))
    test_mses.append(mean_squared_error(y_test, p2))

# Optimal Model Complexity
best_complexity = test_mses.index(min(test_mses)) + 1
best_mse = min(test_mses)
