// Disjoint set (Union-Find)
class GfG {
    int find(int par[], int x) {
        // add code here.
        if(par[x] == x) return x;
        return find(par , par[x]);
    }

    void unionSet(int par[], int x, int z) {
        
        int ult_parent_x = find(par, x);
        int ult_parent_z = find(par,z);
        
        par[ult_parent_x] = ult_parent_z;
        
        
        // add code here.
    }
}