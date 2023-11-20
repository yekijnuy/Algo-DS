void maxHeapPercolateDown(int nodeIndex, int[] heapArray, int heapSize) {
   int childIndex = 2 * nodeIndex + 1;
   int value = heapArray[nodeIndex];
      
   while (childIndex < heapSize) {
      // Find the max among the node and all the node's children
      int maxValue = value;
      int maxIndex = -1;
      int i = 0;
      while (i < 2 && i + childIndex < heapSize) {
         if (heapArray[i + childIndex] > maxValue) {
            maxValue = heapArray[i + childIndex];
            maxIndex = i + childIndex;
         }
         i++;
      }
         
      if (maxValue == value) {
         return;
      }
         
      // Swap heapArray[nodeIndex] and heapArray[maxIndex]
      int temp = heapArray[nodeIndex];
      heapArray[nodeIndex] = heapArray[maxIndex];
      heapArray[maxIndex] = temp;
         
      nodeIndex = maxIndex;
      childIndex = 2 * nodeIndex + 1;
   }
}
   
// Sorts the array of numbers using the heap sort algorithm
void heapSort(int[] numbers) {
   // Heapify numbers array
   int i = numbers.length / 2 - 1;
   while (i >= 0) {
      maxHeapPercolateDown(i, numbers, numbers.length);
      i--;
   }
                
   i = numbers.length - 1;
   while (i > 0) {
      // Swap numbers[0] and numbers[i]
      int temp = numbers[0];
      numbers[0] = numbers[i];
      numbers[i] = temp;

      maxHeapPercolateDown(0, numbers, i);
      i--;
   }
}