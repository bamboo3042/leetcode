/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution:GuessGame() {
    override fun guessNumber(n:Int):Int {
        var s = 1L
        var e = n.toLong()
        var m = n/2
        var r = guess(m)
        
        while(r != 0) {
            if(r == -1) e = m-1L
            else s = m+1L
            m = ((s + e) / 2).toInt()
            r = guess(m)
        }
        
        return m
    }
}