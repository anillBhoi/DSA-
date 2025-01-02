
class AccountMerge721 {   //tc O(VlogV)

    // method for dfs 
    public void dfs(String srcEmail, HashSet<String>visited,HashMap<String,List<String>> adjMap, List<String>subList ){
        
        visited.add(srcEmail);
        subList.add(srcEmail);
        if(!adjMap.containsKey(srcEmail)){
         return;
        }
        for(String neighbour :adjMap.get(srcEmail)){
         if(!visited.contains(neighbour)){
             dfs(neighbour,visited,adjMap,subList);
         }
        }
    }
 
     public List<List<String>> accountsMerge(List<List<String>> accounts) {
         // create a Adjecency Map
         HashMap<String,List<String>> adjMap = new HashMap<>();
         // go for all accounts
         for(List<String>account : accounts ){
             String firstEmail = account.get(1);
             for(int i=2; i<account.size(); i++){
                 String currEmail = account.get(i);
               if(!adjMap.containsKey(firstEmail)){ // if first email is not in map
                  adjMap.put(firstEmail,new ArrayList<>());
               }
               adjMap.get(firstEmail).add(currEmail);
               
 
               if(!adjMap.containsKey(currEmail)){ // if first email is not in map
                  adjMap.put(currEmail,new ArrayList<>());
               }
               adjMap.get(currEmail).add(firstEmail);
             }    
         }
 
         // now perform dfs 
         List<List<String>> res = new ArrayList<>();
         HashSet<String>visited = new HashSet<>();
         for(List<String> account : accounts){
             String firstEmail = account.get(1);
             if(!visited.contains(firstEmail)){
                 List<String> subList = new ArrayList<>();
                 dfs(firstEmail,visited,adjMap,subList);
                 Collections.sort(subList);
                 subList.add(0,account.get(0));
                 res.add(subList);
             }
         }
 
         return res;
         
     }
 }