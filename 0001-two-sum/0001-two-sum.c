/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
typedef struct {
    int key;
    int value;
} HashMapEntry;

typedef struct {
    HashMapEntry* entries;
    int size;
} HashMap;
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    HashMap map = {malloc(numsSize * sizeof(HashMapEntry)), numsSize};
    int* result = (int*)malloc(2 * sizeof(int));
    
    for (int i = 0; i < numsSize; i++) {
        int diff = target - nums[i];
        for (int j = 0; j < i; j++) {
            if (map.entries[j].key == diff) {
                result[0] = map.entries[j].value;
                result[1] = i;
                *returnSize = 2;
                free(map.entries);
                return result;
            }
        }
        map.entries[i].key = nums[i];
        map.entries[i].value = i;
    }
    
    *returnSize = 0;
    free(map.entries);
    return NULL;
}