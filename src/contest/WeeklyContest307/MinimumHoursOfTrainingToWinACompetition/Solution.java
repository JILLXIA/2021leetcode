package contest.WeeklyContest307.MinimumHoursOfTrainingToWinACompetition;

public class Solution {
	public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
		int addExperience = 0;
		int resultExperience = 0;
		for(int i = 0;i<energy.length;i++){
			initialEnergy -= energy[i];
			if(initialExperience <= experience[i]){
				addExperience = experience[i] + 1 - initialExperience;
				resultExperience += addExperience;
			}
			initialExperience += addExperience + experience[i];
			addExperience = 0;
		}
		int resultEnergy = 0;
		if(initialEnergy <= 0){
			resultEnergy = -initialEnergy + 1;
		}
		return resultExperience+resultEnergy;
	}
}
