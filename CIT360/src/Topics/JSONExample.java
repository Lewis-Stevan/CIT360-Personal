package Topics;
/* The entire process is JVM independent, means that an object can be serialized on
 * one platform and deserialized on another platform
 */
//Class implements java.io.Serializable making it serializable
public class JSONExample implements java.io.Serializable {

	//Variables are defined
	public String name;
	public String address;
	
	//Output for name and address
	public void mailingAddress() {
		System.out.println("The mailing address for " + name + " is " + address);
	}
}
