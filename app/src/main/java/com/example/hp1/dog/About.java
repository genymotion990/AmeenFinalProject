package com.example.hp1.dog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        Intent intent = getIntent();
        int x = intent.getIntExtra("info", -1);
        updateInfo(x);
    }

    public void updateInfo(int team) {

        if(team==-1)
            tvInfo.setText("gdhdh");//ekteb an el ablikatzia
        if(team==0)
            tvInfo.setText("Pit bull is the common name for a type of dog. Formal breeds often considered to be of the pit bull type include the American Pit Bull Terrier, American Staffordshire Terrier, American Bully, and Staffordshire Bull Terrier.[1][2] The American Bulldog is also sometimes included. Many of these breeds were originally developed as fighting dogs from cross breeding bull-baiting dogs (used to hold the faces and heads of larger animals such as bulls) and terriers. After the use of dogs in blood sports was banned, such dogs were used as catch dogs in the United States for semi-wild cattle and hogs, to hunt and drive livestock, and as family companions.[3] Despite dog fighting now being illegal in the United States, it still exists as an underground activity, and pit bulls are a common breed of choice.");//ekteb an el pitball

        if (team == 1) {
            tvInfo.setText("The Doberman Pinscher was developed in Germany during the late 19th century, primarily as a guard dog. His exact ancestry is unknown, but he’s believed to be a mixture of many dog breeds, including the Rottweiler, Black and Tan Terrier, and German Pinscher. With his sleek coat, athletic build, and characteristic cropped ears and docked tail, the Doberman Pinscher looks like an aristocrat. He is a highly energetic and intelligent dog, suited for police and military work, canine sports, and as a family guardian and companion.\n" +
                    "Read more at http://dogtime.com/dog-breeds/doberman-pinscher#rPB3cqCMdlTI5iC2.99");
        }
        if (team == 2)
            tvInfo.setText("The poodle is a group of formal dog breeds, the Standard Poodle, Miniature Poodle and Toy Poodle. The origins of the poodles are still discussed with a dispute over whether the poodle descends from the old French Barbet breed or from Germany as a type of water dog.");
        if (team == 3)
            tvInfo.setText("The German Shepherd (German: Deutscher Schäferhund, German pronunciation: [ˈʃɛːfɐˌhʊnt]) is a breed of medium to large-sized working dog that originated in Germany. The breed's officially recognized name is German Shepherd Dog in the English language (sometimes abbreviated as GSD). The breed is also known as the Alsatian in Britain and Ireland.[5] The German Shepherd is a relatively new breed of dog, with their origin dating to 1899. As part of the Herding Group, German Shepherds are working dogs developed originally for herding sheep. Since that time however, because of their strength, intelligence, trainability, and obedience, German Shepherds around the world are often the preferred breed for many types of work, including disability assistance, search-and-rescue, police and military roles, and even acting.[6] The German Shepherd is the second-most registered breed by the American Kennel Club[7] and seventh-most registered breed by The Kennel Club in the United Kingdom.[8]");
        if (team == 4)
            tvInfo.setText("JACK RUSSELL TERRIER\n" +
                    "Developed in England some 200 years ago to hunt foxes, the Jack Russell Terrier, also known as the Parson Russell Terrier, is a lively, independent, and clever little dog. He’s charming and affectionate, but he’s also a handful to train and manage. For experienced dog owners only!\n"
            );
        if (team == 5)
            tvInfo.setText("1-Dogs don’t just fill your heart; they actually make it stronger. Studies show that having a canine companion is linked to lower blood pressure, reduced cholesterol, and decreased triglyceride levels, which contribute to better overall cardiovascular health and fewer heart attacks." +
                    "2-It’s widely believed that dog owners are less prone to depression than the dog-less, largely because they seem to help in so many other areas of health and wellbeing. The truth is somewhat more complicated." +
                    "3-There’s a reason therapy dogs are so effective: Spending just a few minutes with a pet can lower anxiety and blood pressure, and increase levels of serotonin and dopamine, two neurochemicals that play big roles in calm and wellbeing.");

        if(team==6)
            tvInfo.setText("1-There are more than 150 dog breeds, divided into 8 classes: sporting, hound, working, terrier, toy, non-sporting, herding, and miscellaneous.\n" +
                    "\n" +
                    "2– According to a recent survey, the most popular name for a dog is Max. Other popular names include Molly, Sam, Zach, and Maggie.\n" +
                    "\n" +
                    "3– Dogs can vary in size from a 36 inch (150+ lb.) Great Dane to a 2 lb. Chihuahua.\n" +
                    "\n" +
                    "4– Puppies and kittens can be adopted as early as 8 weeks of age.  Until then, they should stay with their moms and littermates.\n" +
                    "\n" +
                    "5– About 1/3 of the dogs that are surrendered to animal shelters are purebred dogs.\n" +
                    "\n" +
                    "6– Contrary to popular belief, dogs do not sweat by salivating. They sweat through the pads of their feet.\n" +
                    "\n" +
                    "7– Dogs may not have as many taste buds as we do (they have about 1,700 on their tongues, while we humans have about 9,000), but that doesn’t mean they’re not discriminating eaters. They have over 200 million scent receptors in their noses (we have only 5 million) so it’s important that their food smells good and tastes good.\n" +
                    "\n" +
                    "8– The term “dog days” has nothing to do with dogs. It dates back to Roman times, when it was believed that Sirius, the Dog Star, added its heat to that of the sun from July 3 to August 11, creating exceptionally high temperatures.\n" +
                    "\n" +
                    "9– Did you know they were female?  Toto’s role in The Wizard of Oz was played by a female Cairn Terrier named Terry, and the Taco Bell dog is actually a female Chihuahua named Gidget.\n" +
                    "\n" +
                    "10– Former US President Teddy Roosevelt had a Pit Bull named Pete.\n" +
                    "\n" +
                    "11– An adult dog has 42 teeth.\n" +
                    "\n" +
                    "12– If a dog isn’t spayed or neutered, a female dog, her mate and their offspring can product 67,000 dogs in 6 years.\n" +
                    "\n" +
                    "13– The most successful mountain rescue dog ever was a St Bernard named Barry, who lived during the early 1800’s and saved 40 lives.\n" +
                    "\n" +
                    "14– It was recently discovered that dogs do see in color, just not as vivid as we see.\n" +
                    "\n" +
                    "15– Nearly all but two breeds of dogs have pink tongues: the Chow Chow and the Shar-pei both have black tongues.\n" +
                    "\n" +
                    "16– The Poodle haircut was originally meant to improve the dog’s swimming abilities as a retriever, with the pom-poms left in place to warm their joints.\n" +
                    "\n" +
                    "17– The top five favorite breeds of dogs in the US are: Labrador Retriever, Golden Retriever, German Shepherd, Beagle, and Dachshund.\n" +
                    "\n" +
                    "18– The Basenji is the only barkless dog in the world.\n" +
                    "\n" +
                    "19– Greyhounds can reach a speed of up to 45 miles per hour.\n" +
                    "\n" +
                    "20– When a puppy is born, he is blind, deaf, and toothless.\n" +
                    "\n" +
                    "21– All dogs, regardless of breed, are direct descendants of wolves and technically of the same species.\n" +
                    "\n" +
                    "22– A dog’s whiskers — found on the muzzle, above the eyes and below the jaws — are technically known as vibrissae. They are touch-sensitive hairs than actually sense minute changes in airflow.\n" +
                    "\n" +
                    "23– Dogs are capable of locating the source of a sound in 6/100ths of a second by using their swiveling ears like radar dishes.\n" +
                    "\n");


    }
}