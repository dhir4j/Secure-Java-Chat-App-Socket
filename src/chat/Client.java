package chat;
/**
 *
 * @author dhir4j
 */
public class Client 
{

    public static void main(String[] args) 
    {
        chat_client client=new chat_client("127.0.0.1");
        client.startRunning();
    }
}
