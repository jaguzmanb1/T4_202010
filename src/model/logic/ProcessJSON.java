package model.logic;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class ProcessJSON 
{

	public static void main(String[] args) throws MalformedURLException, IOException
	{		
		JsonReader reader = new JsonReader(new StringReader("[{\"atributo\":\"valor\", \"lista\":[{\"item\":\"item1\"}]}]"));
		handleArray(reader); // En este caso porque sabemos que siempre nos va a llegar una lista de objetos
	}

	/**
	 * Cuando identifica que encontró un objeto se procesa los atributos atómicos y compuestos (como listas)
	 * @param reader
	 * @throws IOException
	 */
	private static void handleObject(JsonReader reader) throws IOException
	{
		reader.beginObject();
		while (reader.hasNext()) {
			JsonToken token = reader.peek();
			if (token.equals(JsonToken.BEGIN_ARRAY))
				handleArray(reader);
			else if (token.equals(JsonToken.END_OBJECT)) {
				reader.endObject();
				return;
			} else
				handleNonArrayToken(reader, token);
		}
	}

	public static void handleArray(JsonReader reader) throws IOException { 
		reader.beginArray(); 
		while (true) { 
			JsonToken token = reader.peek(); 
			if (token.equals(JsonToken.END_ARRAY)) { 
				reader.endArray(); 
				break; 
			} 
			else if (token.equals(JsonToken.BEGIN_OBJECT)) { 
				handleObject(reader); 
			} 
			else if (token.equals(JsonToken.END_OBJECT)) 
			{ 
				reader.endObject(); 
			} 
			else handleNonArrayToken(reader, token); } }

	public static void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException
	{
		if (token.equals(JsonToken.NAME))
			System.out.println(reader.nextName());
		else if (token.equals(JsonToken.STRING))
			System.out.println(reader.nextString());
		else if (token.equals(JsonToken.NUMBER))
			System.out.println(reader.nextDouble());
		else if (token.equals(JsonToken.BOOLEAN))
			System.out.println(reader.nextBoolean());
		else
			reader.skipValue();
	}
}
