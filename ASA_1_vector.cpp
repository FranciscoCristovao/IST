#include<iostream>
#include<list>
#include<algorithm>
#include<vector>

using namespace std;

vector<int> _lows;
vector<int> _disc;
vector<bool> _visited;
vector<int> _parents;
vector<bool> _artPoints;
int _time = 0;

class Graph{
	int vertices;
	vector<vector<int> > _adj;


public:
	Graph(int v);
	void addEdge(int v1, int v2);
	int numConnections(int v);
	bool shareEdge(int v1, int v2);
	void DFS(int v, int t);
};

Graph::Graph(int v){
	vertices = v;
	_adj = vector<vector<int> >(v);
}

void Graph::addEdge(int v1, int v2){
	_adj[v1].push_back(v2);
	_adj[v2].push_back(v1);
}

int Graph::numConnections(int v){
	return _adj[v].size();
}

bool Graph::shareEdge(int v1, int v2){
	if(find(_adj[v1].begin(), _adj[v1].end(), v2) != _adj[v1].end())
		return true;
	return false;
}

void Graph::DFS(int v, int t){
	_visited[v] = true;
	_disc[v] = t;
	_lows[v] = t;
	int child = 0;
	bool _artPoint = false;

	for(vector<int>::iterator i = _adj[v].begin(); i != _adj[v].end(); i++){
		int u = *i;
		if(_visited[u] == false){
			_parents[u] = v;
			DFS(u, t+1);
			child++;
			if(_lows[u] >=_disc[v]) _artPoint = true;
			else{
				_lows[v] = min(_lows[u], _lows[v]);
			}
		}
		else{
			_lows[v] = min(_lows[v], _disc[u]);
		}
	}
	if((_parents[v] == -1 && child >= 2) || (_parents[v] != -1 && _artPoint)){
		_artPoints[v] = true;
	}
}


int main(){

	int vertices, links;
	int v1, v2;

	cin >> vertices >> links;
	if(links == vertices){
		cout << "0\n-1 -1" << "\n";
		return 0;
	} 
	Graph graph(vertices);
	_lows = vector<int>(vertices, -1);
	_disc = vector<int> (vertices, -1);
	_parents = vector<int> (vertices, -1);
	_visited = vector<bool> (vertices, false);
	_artPoints = vector<bool> (vertices, false);

	while(links > 0){
		cin >> v1 >> v2;
		graph.addEdge(v1-1, v2-1);
		links--;
	}
	graph.DFS(v1-1, 0);

	int j = 0;
	bool flag = true;
	int max = 0;
	int min = 0;
	for(unsigned int i = 0; i < _artPoints.size(); i++){
		if(_artPoints[i] == true){
			if(flag){
				min = i+1;
				flag = false;
			}
			max = i+1;
			j++;
		}
	}
	cout << j << "\n";
	cout << min << " " << max << "\n";
	
	return 0;
} 
