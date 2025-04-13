public class SetUnsetRightmost {
    public static int setRUB(int n){
        return (n|(n+1));
    }
    public static int unsetRSB(int n){
        return (n&(n-1));
    }
}
