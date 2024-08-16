class Solution {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val trie = Trie()
        val str = StringBuilder()

        products.forEach { trie.insert(it) }

        return searchWord.map { c ->
            str.append(c)

            trie.search(str.toString())
        }
    }

    private class Trie {
        private val head = Node()

        fun insert(word: String) {
            var temp = head

            word.forEach { c ->
                temp = temp.createOrGetChild(c)
            }

            temp.data = word
        }

        fun search(word: String): List<String> {
            var temp = head
            val result = mutableListOf<String>()

            word.forEach { c ->
                temp.getChild(c)?.also {
                    temp = it
                } ?: return result
            }

            dfs(temp, result)

            return result
        }

        private fun dfs(temp: Node, answer: MutableList<String>) {
            if (answer.size == 3) return

            if (temp.data != null) answer.add(temp.data!!)

            temp.child.forEach { node ->
                if (node != null) dfs(node, answer)
            }
        }

        data class Node(
            var data: String? = null,
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
}