public class dialogues5
{
    String dialogues[] = new String[35];

    dialogues5()
    {
        //Scene One    	
        dialogues[0] = "When you return, you find the table empty with only your glasses.";
        dialogues[1] = "Yours half empty, while Harry's is still full";
        dialogues[2] = "The red on it is an eye striking color as it draws your attention";        
        dialogues[3] = "…It really is a beautiful color ";              
        dialogues[4] = "Though yours has flattened, the white bubbles settling and popping";
        dialogues[5] = "It still gives an elegant demeanor that you dont get.";
        dialogues[6] = "He seemed so down to earth, but he has a wine preference?";
        dialogues[7] = "Your thoughts are interrupted by the POI returning to your peripheral";
        dialogues[8] = "Sitting across from you with an unreadable expression"; 
        dialogues[9] = "It morphed into a sweet smile that you're getting familiar with. Strange.";      
        dialogues[10] = "'Sorry I took so long'";//MC
        dialogues[11] = "H: No worries, I had to find the bathroom too.";
        dialogues[12] = "H: I think the waiter needs us to order though";//HARRY
        dialogues[13] = "'Oh, right! Waiter-!'"; //MC
        dialogues[14] = "You call the waiter and you both say what you want on impulse.";
        dialogues[15] = "He ordered the steak, you ordered the lamb";
        dialogues[16] = "Normally you would order something more affordable"; 
        dialogues[17] = "But seeing where you're currently dining in";
        dialogues[18] = "You would treat it like your last meal."; 
        dialogues[19] = "When the food arrives the tension drains instantly";
        dialogues[20] = "Mawing down your food like a starved wolf.";
        dialogues[21] = "By contrast, Harrison eats methodically, cutting it into little pieces";
        dialogues[22] = "A perfect ratio of sauce and rice coupled with mashed potatoes and meat.";
        dialogues[23] = "As he's about to take a sip of his wine, he looks into your eyes";
        dialogues[24] = "H: Something wrong?"; //HARRY
        dialogues[25] = "You feel a bit flustered, you're unsure why"; 
        dialogues[26] = "Dinner goes smoothly, you pay for the meal and walk off the extra calories";
        dialogues[27] = "Hee seems happy to take your arm in his as the waiter opens up the door"; 
        dialogues[28] = "H: Now we can get out of here, hopefully there aren't any more exes outside"; //HARRY
        dialogues[29] = "He chuckles, and you chuckle too"; 
        dialogues[30] = "...";
        dialogues[31] = "When did you mention about being an ex?";
        dialogues[32] = "H: Well then, will you do me the honor of inviting you somewhere?";
        dialogues[33] = "I have a surprise gift for you"; //HARRY

    }

    public String getDialogueText(int index)
    {
        return dialogues[index];
    }
    public int getDialogueLength()
    {
        return dialogues.length;
    }


 
}