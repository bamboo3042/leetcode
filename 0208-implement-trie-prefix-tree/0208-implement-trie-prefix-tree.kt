class Trie() {
    private val head = Node()

    fun insert(word: String) {
        var temp = head
        
        word.forEach { c ->
            temp = temp.createOrGetChild(c)
        }

        temp.isEnd = true
    }

    fun search(word: String): Boolean {
        var temp = head

        word.forEach { c ->
            temp.getChild(c)?.also { 
                temp = it
            } ?: return false
        }

        return temp.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var temp = head
        var index = 0
        
        prefix.forEach { c ->
            temp.getChild(c)?.also {
                temp = it
            } ?: return false
        }

        return true
    }

    data class Node(
        var isEnd: Boolean = false,
        val child: MutableList<Node?> = MutableList(26) { null },
    ) {
        fun createOrGetChild(c: Char): Node {
            val i = c.code - 97
            if (child[i] == null) {
                child[i] = Node()
            }

            return child[i]!!
        }

        fun getChild(c: Char): Node? {
            return child[c.code - 97]
        }
    }
}