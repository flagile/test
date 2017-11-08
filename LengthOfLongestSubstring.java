import java.util.Iterator;
import java.util.LinkedHashSet;

public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		int count = 0;
		int max = 0;
		if (s != null && !"".equals(s)) {
			LinkedHashSet<Character> countSet = new LinkedHashSet<Character>();
			for (int i = 0; i < s.length(); i++) {
				char key = s.charAt(i);
				if (!countSet.contains(key)) {
					countSet.add(key);

				} else {

					LinkedHashSet<Character> countSetClone = (LinkedHashSet) countSet
							.clone();
					Iterator<Character> iterator = countSetClone.iterator();
					while (iterator.hasNext()) {
						Character temp = iterator.next();
						if (temp == key) {
							countSet.remove(temp);
							count--;
							break;
						} else {
							countSet.remove(temp);
						}
						count--;
					}

					countSet.add(key);
				}
				count++;
				if (count > max) {
					max = count;
				}
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(lengthOfLongestSubstring("DQABCAFYG"));

	}

}
