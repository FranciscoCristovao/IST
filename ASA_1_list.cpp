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
	vector<list<int> > _adj;


public:
	Graph(int v);
	void addEdge(int v1, int v2);
	void DFSvisit(int v, int t);
	void formatOutput();
};

Graph::Graph(int v){
	vertices = v;
	_adj = vector<list<int> >(v); 
}

void Graph::addEdge(int v1, int v2){
	_adj[v1].push_back(v2);
	_adj[v2].push_back(v1);
}

void Graph::DFSvisit(int v, int t){
	_visited[v] = true;
	_disc[v] = t;
	_lows[v] = t;
	int child = 0;
	bool _artPoint = false;

	list<int>::iterator i;
	for(i = _adj[v].begin(); i != _adj[v].end(); i++){
		int u = *i;
		if(_visited[u] == false){
			_parents[u] = v;
			DFSvisit(u, t+1);
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
void Graph::formatOutput(){

	int j = 0;
	bool flag = true;
	int max = -1;
	int min = -1;
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
	
}


int main(){

	int vertices, links;
	int v1, v2;
	cin >> vertices >> links;


	Graph graph(vertices);
	_lows = vector<int>(vertices, -1);
	_disc = vector<int> (vertices, -1);
	_parents = vector<int> (vertices, -1);
	_visited = vector<bool> (vertices, false);
	_artPoints = vector<bool> (vertices, false);


	while(links > 0){
		cin >> v1 >> v2;
		graph.addEdge(v1-1, v2-1); //para o vertice 1 ficar no indice 0 da lista
		links--;
	}
	graph.DFSvisit(v1-1, 0);

	graph.formatOutput();

	return 0;
} 
