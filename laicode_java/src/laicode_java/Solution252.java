package laicode_java;

import java.lang.reflect.Array;
import java.util.*;

//Longest Palindromic Substring
//Given a string S, find the longest palindromic substring in S.
//
//Assumptions
//There exists one unique longest palindromic substring.
//The input S is not null.
//Examples
//Input:     "abbc"
//Output:  "bb"
/* a
 *  b bb abb
 *   b
 * 
 */
//
//Input:     "abcbcbd"
//Output:  "bcbcb"
/*	abcbcbd
 * 	a
 * 	 b abc
 *    c bcb abcbc
 *     b cbc bcbcb abcbcbd
 *      c bcb cbcbd
 *       b cbd
 *        d  
 */
public class Solution252 {
	public String longestPalindrome(String s) {
		if(s==null || s.length()<2) {
			return s;
		}
		int leng=s.length();
		String result="";
		int dist=0;
		boolean[][] isPalindrome = new boolean[leng+1][leng+1]; 
		for(int end=1; end<=leng; end++) {
			for(int start=end; start>0; start--) {
				if(s.charAt(start-1)==s.charAt(end-1)) {
					isPalindrome[start][end] = end-start<2 || isPalindrome[start+1][end-1];
				}
				if(isPalindrome[start][end] && end-start>=dist) {
					result=s.substring(start-1, end);
					dist = end-start;
				}
			}
		}
		return result;
	}
	
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		for(int i=0; i<intervals.length-1; i++) {
			if(intervals[i].end > intervals[i+1].start) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution252 ss = new Solution252();
		System.out.println(ss.longestPalindrome(""));
		System.out.println(ss.longestPalindrome("abcbcbd"));
		System.out.println(ss.longestPalindrome("abbc"));
	}
}
