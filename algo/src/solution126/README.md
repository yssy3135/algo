'슈퍼컴퓨터를 통해서 다른 컴퓨터들로 통신이 가능하게끔 네트워크를 연결할 때, 그 시간이 최소가 되도록 하는 것' 다익스트라 이용해서 최단거리를 구한다. 최단거리를 구할 떄 값이 갱신되는 과정 예) 1번에서 4번 까지가 이동거리가 4인데 1번에서 2번을 거쳐 4번으로가면 3이다 int ans[n+1] 배열을 만들어 이때 ans[4] = 2; 이런 식으로 답을 저장한다.