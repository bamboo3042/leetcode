class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if(word1.length != word2.length) return false

        val list1 = word1.groupingBy { it }.eachCount()
        val list2 = word2.groupingBy { it }.eachCount()

        return list1.keys.toHashSet() == list2.keys.toHashSet() && list1.values.sorted() == list2.values.sorted()
    }
}