class Trie() {
    private val head = Node(false, mutableMapOf())

    fun insert(word: String) {
        var temp = head
        var index = 0

        while (index < word.length) {
            if (temp.child.containsKey(word[index])) {
                temp = temp.child[word[index]]!!
            }
            else {
                temp.child[word[index]] = Node(false, mutableMapOf())
                temp = temp.child[word[index]]!!
            }
            index++
        }

        temp.isEnd = true
    }

    fun search(word: String): Boolean {
        var temp = head
        var index = 0

        while (index < word.length) {
            if (!temp.child.containsKey(word[index])) return false

            temp = temp.child[word[index]]!!

            index++
        }

        return temp.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var temp = head
        var index = 0

        while (index < prefix.length) {
            if (!temp.child.containsKey(prefix[index])) return false

            temp = temp.child[prefix[index]]!!

            index++
        }

        return true
    }

    data class Node(
        var isEnd: Boolean,
        val child: MutableMap<Char, Node>
    )
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */