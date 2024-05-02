package Abs_Inter;

public class Replace_Str {
	public static void main(String[] args) {
		String word="Cook book";
				
				String word2=word.replace('o', 'e');

				String word3=word.replace("Cook","Computer");
				
				System.out.println("word:"+word);
				System.out.println("word2:"+word2);
				System.out.println("word3:"+word3);
				
				String message="The boy is standing in the road.The dog is sitting near the boy.";
				String message2=message.replace("boy", "girl");
				String message3=message.replaceFirst("boy", "girl");
				
				System.out.println("message:"+message);
				System.out.println("message2:"+message2);
				System.out.println("message3"+message3);
			}
}
