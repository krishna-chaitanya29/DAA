class Item implements Comparable<Item>{
    int value , weight;
    double ratio;
    
    public Item(int value, int weight, double ratio) {
        this.value = value;
        this.weight = weight;
        this.ratio = ratio;
    }

    @Override
    public int compareTo(Item other) {
        // TODO Auto-generated method stub
        return Double.compare(other.ratio, this.ratio);
    }
}

public class solution{
    public static void main(String[] args) {
        
    }
} 