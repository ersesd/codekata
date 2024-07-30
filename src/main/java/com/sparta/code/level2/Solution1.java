import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Solution11 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

		// 소비자가 원하는 제품
		HashMap<String, Integer> wants = new HashMap<>();
		for (int i = 0; i < want.length; i++) {
			wants.put(want[i], number[i]);
		}

		// 마트에서 할인하는 제품
		HashMap<String, Integer> discounts = new HashMap<>();
		
		// 세일 날짜가 지난 제품
		int over = 0;
		
		for (int i = 0; i < discount.length; i++) {
			if (discounts.containsKey(discount[i])) {
				int value = discounts.get(discount[i]);
				discounts.put(discount[i], value + 1);
			} else {
				discounts.put(discount[i], 1);
			}
			
			if (i >= 10) {
				// 세일이 끝난 제품은 삭제
				String key = discount[over++];
				int value = discounts.get(key);
				if (value == 1) {
					discounts.remove(key);
				} else {
					discounts.put(key, value - 1);
				}
			}
			
			// 소비자가 원하는 제품의 정보와 할인하는 제품의 정보가 일치여부
			if (isSame(wants, discounts))
				answer++;
		}

		return answer;
    }
    
    public boolean isSame(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
		// 크기가 다른 경우 false
		if (map1.size() != map2.size())
			return false;

		Set<String> keys = map1.keySet();
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			String key = it.next();

			// key값이 다른 경우 false
			if (!map2.containsKey(key))
				return false;

			// value값이 다른 경우 false
			if (map1.get(key) != map2.get(key))
				return false;
		}

		return true;
	}
}