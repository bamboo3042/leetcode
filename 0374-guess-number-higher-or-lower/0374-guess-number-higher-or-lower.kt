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
        var s = 1
        var e = n
        var m = n/2
        var r = guess(m)
        
        while(r != 0) {
            if(r == -1) e = m-1
            else s = m+1
            m = ((s.toLong() + e.toLong()) / 2).toInt()
            r = guess(m)
        }
        
        return m
    }
}