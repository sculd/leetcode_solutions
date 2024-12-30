class Solution:
    def maxScore(self, n: int, k: int, stay_score: List[List[int]], travel_score: List[List[int]]) -> int:
    	dp = [[0 for _ in range(n)] for _ in range(k)]
    	
    	for ori in range(n):
    		dp[k-1][ori] = max([stay_score[k-1][ori]] + travel_score[ori])
    		
    	for i in range(k-1)[::-1]:
    		for ori in range(n):
    			dp[i][ori] = stay_score[i][ori] + dp[i+1][ori]
    			dp[i][ori] = max(dp[i][ori], max([travel_score[ori][dest] + dp[i+1][dest] for dest in range(n)]))
    	
    	return max(dp[0])

