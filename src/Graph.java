import java.util.*;

public class Graph<T> {
    private List<Vertex<T>> vertices = new ArrayList<>();

    public Vertex<T> createVertex(T value) {
        Vertex<T> v = new Vertex<>(value);
        vertices.add(v);
        return v;
    }

    public void createEdge(Vertex<T> a, Vertex<T> b) {
        a.getAdjacent().add(b);
        b.getAdjacent().add(a);
        // добавляем их друг друга в их списки смежности
        // ВАШ КОД
    }

    public boolean isConnected(Vertex<T> a, Vertex<T> b) {
        return dfsFind(a, b, new HashSet<>()); // рекурсивный обход в глубину
    }

    // метод отвечает на вопрос, нашли ли мы обходом из v вершину target с учётом
    // посещённых вершин, которые записаны в visited
    private boolean dfsFind(Vertex<T> v, Vertex<T> target, Set<Vertex<T>> visited) {
        // если вершина в которую зашли (v) это та которую мы искали (target), то поиск закончен
        if (v.equals(target)) {
            return true; // нашли
        }
        visited.add(v); // запоминаем вершину, которую посетили

        for (Vertex<T> currentAccount : vertices) {
            if (currentAccount.getAdjacent().contains(v) && !visited.contains(currentAccount)) {
                if (dfsFind(currentAccount, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
