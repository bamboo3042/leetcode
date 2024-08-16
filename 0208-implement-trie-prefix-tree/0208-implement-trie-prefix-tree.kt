class Trie() {
    private val head = Node()

    fun insert(word: String) {
        var temp = head

        word.forEach { c ->
            if (!temp.child.containsKey(c)) temp.child[c] = Node()
            temp = temp.child[c]!!
        }

        temp.isEnd = true
    }

    fun search(word: String): Boolean {
        var temp = head
        
        word.forEach { c ->
            if (!temp.child.containsKey(c)) return false
            temp = temp.child[c]!!
        }

        return temp.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var temp = head
        
        prefix.forEach { c ->
            if (!temp.child.containsKey(c)) return false
            temp = temp.child[c]!!
        }

        return true
    }

    data class Node(
        var isEnd: Boolean = false,
        val child: MutableMap<Char, Node> = mutableMapOf(),
    )
}