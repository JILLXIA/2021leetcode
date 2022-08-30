package contest.Weekly308;

public class MinimumAmountOfTimeToCOllectGarbage {
	public int garbageCollection(String[] garbage, int[] travel) {
		int m_index = 0;
		int g_index = 0;
		int p_index = 0;

		int[] preSumTravel = new int[travel.length + 1];
		for(int i = 1;i<preSumTravel.length;i++){
			preSumTravel[i] = preSumTravel[i-1] + travel[i-1];
		}
		int result = 0;
		for(int i = garbage.length-1;i >= 0;i--){
			result += garbage[i].length();
			if(m_index==0 && garbage[i].contains("M")){
					m_index = i;
			}
			if(g_index==0 && garbage[i].contains("G")){
				g_index = i;
			}
			if(p_index==0 && garbage[i].contains("P")){
				p_index = i;
			}
		}
		result += preSumTravel[m_index] + preSumTravel[p_index] + preSumTravel[g_index];
		return result;
	}
}
