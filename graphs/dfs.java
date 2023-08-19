public boolean[] dfs(int start) {
    boolean[] isVisited = new boolean[adjVertices.size()];
    return dfsRecursive(start, isVisited);
}

private boolean[] dfsRecursive(int current, boolean[] isVisited) {
    isVisited[current] = true;
    visit(current);
    for (int dest : adjVertices.get(current)) {
        if (!isVisited[dest])
            dfsRecursive(dest, isVisited);
    }
    return isVisited;
}
