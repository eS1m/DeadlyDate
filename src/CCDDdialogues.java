public class CCDDdialogues
{
    String dialogues[] = new String[23];
    String dialogues1[] = new String[44];
    String dialogues2[] = new String[10];

    CCDDdialogues()
    {
        //Scene One
        dialogues[0] = "'This is a public service announcement!'";
        dialogues[1] = "'A serial killer is currently on the loose.'";
        dialogues[2] = "'Police have currently found a total of *click*'";
        dialogues[3] = "Wasn't really about the news anyway, let's change the channels.";
        dialogues[4] = "*Click*";
        dialogues[5] = "Much better. It really completes the look of the outfit";
        dialogues[6] = "(That you procrastinated)";
        dialogues[7] = "That you're currently wearing for a blind date!";
        dialogues[8] = "(It's barely finished)";
        dialogues[9] = "You agreed to meet them at a fancy restaurant that you never heard of.";
        dialogues[10] = "But that just means he's rich, isn't he? He said he would pay for everything.";
        dialogues[11] = "The dress you got is tacky at most...";
        dialogues[12] = "But, let's agree to disagree. You just need to do the job and dress up the part.";
        dialogues[13] = "'Where is my lipstick?...'";
        dialogues[14] = "You didn't do it well.";
        dialogues[15] = "*Brrrrr*";
        dialogues[16] = "Suddenly your phone vibrates as a text message is received in your notifications.";
        dialogues[17] = "It gives the most terrifying message you could ever have in your life";
        dialogues[18] = "'Hey!'";
        dialogues[19] = "Scary stuff";
        dialogues[20] = "Wait, did you forget something?";
        dialogues[21] = "'Im at the front desk right now and I have to put in your name, what should I put?";
        dialogues[22] = "Oh right... your name, what should you say?";

        //Scene OneA
        dialogues1[0] = "You give him your name.";
        dialogues1[1] = "'Bea, that's a lovely name! I'll see you later!'";
        dialogues1[2] = "He texts with smiley faces,  it's cute enough to make you forget you're 20 minutes behind.";
        dialogues1[3] = "'Damn, I'm late!'";
        dialogues1[4] = "You hastily shove the things you need in your small bag, as stated by the women's outfit association.";
        dialogues1[5] = "Putting on your heels, you make your way to the front door.";
        dialogues1[5] = "...before going back because you have to make sure that everythings is in place.";
        dialogues1[6] = "Finally, you left your front door.";
        dialogues1[7] = "With your high heels you try your best to run to the train station, like a giraffe running on stilts.";
        dialogues1[8] = "Perhaps it was better to choose something else to wear";
        dialogues1[9] = "After what feels like hours you arrive at the restaurant.";
        dialogues1[10] = ".";
        dialogues1[11] = "..";
        dialogues1[12] = "...";
        dialogues1[13] = "Woah.";
        dialogues1[14] = "The water was sparkling, waiters rushing to accommodate their guests with numerous knives.";
        dialogues1[15] = "The place shined so brightly the poverty would go blind if they stared for too long.";
        dialogues1[16] = "It was too fancy and as an ordinary middle class citizen";
        dialogues1[17] = "You feel...";
        dialogues1[18] = "Very...";
        dialogues1[19] = "V e r y...";
        dialogues1[20] = "Out of place.";
        dialogues1[21] = "Man: You're here! You look very beautiful.";
        dialogues1[22] = "Man: Apologies for not meeting you sooner, I had to ensure nobody was taking our reservation";
        dialogues1[23] = "A man- taller than you- approaches in a dashing suit and tie";
        dialogues1[24] = "Hypnotizing eyes of burgundy that immediately captures your gaze";
        dialogues1[25] = "Half of their hair is slicked-back, while the rest naturally falls into messy bangs on the side";
        dialogues1[26] = "He is... in layman's terms...";
        dialogues1[27] = "Hot.";
        dialogues1[28] = "Almost too good to be true...";
        dialogues1[29] = "He could slap you with a wad of money and you would like it.";
        dialogues1[30] = "'Oh, Harrison right? My blind date?'";
        dialogues1[31] = "H: I am, it's nice to finally meet you in person. You're lovelier than I imagined";
        dialogues1[32] = "Awee...";
        dialogues1[33] = "H: I do hope I live up to your expectations from our chats";
        dialogues1[34] = "H: I do have a gift for you, just to sweeten the deal if you weren't won over yet";
        dialogues1[35] = "'Oh my, thank you! These are beautiful'";
        dialogues1[36] = "You feel inadequate, but you're not sure why";
        dialogues1[37] = "H: Now, would this be convincing?";
        dialogues1[38] = "Hardly";
        dialogues1[39] = "He laughs, a chuckle fills the air with an uplifting mood";
        dialogues1[40] = "H: Anyway, I'm sure you're freezing. Should we head for our table?";
        dialogues1[41] = "He extends an arm for you to grab on. As if something from a fairytale.";
        dialogues1[42] = "Of course, like the princess you are, you accept the invite.";
        dialogues1[43] = "";

        //Scene OneB
        dialogues2[0] = "You know what? You did way too much just to go out with some guy.";
        dialogues2[1] = "I mean what if he thinks you're ugly? What if he's ugly?";
        dialogues2[2] = "Or worse";
        dialogues2[3] = "What if he's short!?";
        dialogues2[4] = "Having to think about all of this, you decide to turn off your phone.";
        dialogues2[5] = "Days turn into weeks, weeks turn into months. You haven't heard from him again.";
        dialogues2[6] = "Maybe he was never into you in the first place, or else he would've replied back.";
        dialogues2[7] = "Or maybe he just wanted to respect your choice.";
        dialogues2[8] = "Maybe some things are better off left alone.";
        dialogues2[9] = "The End.";
    }

    public String getDialogueText(int index)
    {
        return dialogues[index];
    }
    public int getDialogueLength()
    {
        return dialogues.length;
    }

    public String get1DialogueText(int index)
    {
        return dialogues1[index];
    }
    public int get1DialogueLength()
    {
        return dialogues1.length;
    }

    public String get2DialogueText(int index)
    {
        return dialogues2[index];
    }
    public int get2DialogueLength()
    {
        return dialogues2.length;
    }

}