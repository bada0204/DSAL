/**
 * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
 * 
 * Implement the BrowserHistory class:
 * 1. BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * 2. void visit(string url) Visits url from the current page. It clears up all the forward history.
 * 3. string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. 
 * Return the current url after moving back in history at most steps.
 * 4. string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. 
 * Return the current url after forwarding in history at most steps.
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class problem_1472 {

    private List<String> histories;
    private int cursor;
    private int end;

    public problem_1472(String homepage) {
        this.histories = new ArrayList<String>();
        this.histories.add(homepage);
        this.cursor = 0;
        this.end = 1;
    }
    
    public void visit(String url) {
        this.end = this.cursor + 1;
        if (this.end == this.histories.size()) {
            this.histories.add(this.end++, url);
        } else {
            this.histories.set(this.end++, url);
        }
        this.cursor++;
    }
    
    public String back(int steps) {
        this.cursor = Math.max(0, this.cursor - steps);
        return this.histories.get(this.cursor);
    }
    
    public String forward(int steps) {
        this.cursor = Math.min(this.end - 1, this.cursor + steps);
        return this.histories.get(this.cursor);
    }
    
}
