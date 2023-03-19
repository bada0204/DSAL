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

import ds.DoubleListNode;

public class problem_1472 {

    private DoubleListNode histories;

    public problem_1472(String homepage) {
        this.histories = new DoubleListNode(homepage);
    }
    
    public void visit(String url) {
        DoubleListNode forward = this.histories.getNext();
        if (forward != null) {
            this.histories.setNext(null);
            forward.setPrev(null);
        }
        forward = new DoubleListNode(url);
        this.histories.setNext(forward);;
        forward.setPrev(this.histories);
        this.histories = forward;
    }
    
    public String back(int steps) {
        while (steps > 0 && this.histories.getPrev() != null) {
            this.histories = this.histories.getPrev();
            steps--;
        }
        return this.histories.getValue();
    }
    
    public String forward(int steps) {
        while (steps > 0 && this.histories.getNext() != null) {
            this.histories = this.histories.getNext();
            steps--;
        }
        return this.histories.getValue();
    }
    
}
