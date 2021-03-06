package algs.days.day21;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class DFSSearchAnimation extends AnimationEngine {

	boolean explore (int s, int target) {
		Stack<Integer> stack = new Stack<Integer>();
		color = new int[N];

		// positions in the Queue are Gray and under investigation.
		stack.push(s);
		while (!stack.isEmpty()) {
			Integer u = stack.pop();

			checkPause();  // see if request pause by space bar. 
			
			for (int v : g.adj(u)) {
				if (color[v] == White) {
					color[v] = Gray;
					StdDraw.setPenColor(colors[color[v]]);
					StdDraw.filledCircle(points[v].x, points[v].y, Radius);
					StdDraw.show(delay);
					
					if (v == target) {
						color[v] = Black;
						StdDraw.setPenColor(colors[color[v]]);
						StdDraw.filledCircle(points[v].x, points[v].y, Radius);
						return true;
					}

					stack.push(v);
				}
			}
			
			color[u] = Black;
			StdDraw.setPenColor(colors[color[u]]);
			StdDraw.filledCircle(points[u].x, points[u].y, Radius);
			StdDraw.show(delay);
		}

		return false;
	}
	
	public static void main(String[] args) {
		if (args.length > 0) {
			StdRandom.setSeed(Long.parseLong(args[0]));
		}
		new DFSSearchAnimation().launch();
	}
} 
