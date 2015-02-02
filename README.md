Copyright (c) 2015 Ben Hunter
See the file LICENSE.txt for copying permission.

# bkhunter-notes
Assignment 1 for Cmput 301 Winter 2015 
University Of Alberta

Video Demonstration: https://www.youtube.com/watch?v=imqJS5ah5pA&feature=youtu.be

Unfortunately, I could not implement Serialization with my App.
I went through the StudentPicker Code and tried to adapt it
to my specifications but It did not work. Oddly enought it didn't
do anything, no crashes, or errors. Given more time I would 
investigate this matter, but unfortunately I cannot.

So, without Serialization, I present to you, bkhunter-notes

***********************************************************
                         Sources
***********************************************************
 Note: There should be comments in my code wherever I used
 codefrom these sources

Much inspiration for Layouts, CLasses, and Design
came from Prof. Abram Hindle's video series
StudentPicker
https://www.youtube.com/watch?v=5PPD0ncJU1g&feature=youtu.be

How I Implemented email functionality was largely based on
User fiXedd answer to a similar question. This can be found
at:
https://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application

I didn't end up using ExpandableListViews, but I did use this
tutorial for inspiration earlier.
http://www.101apps.co.za/index.php/articles/expandable-lists.html

I adapted Spinners (Drop-Down lists) in several activities
from the following tutorial by contributor mkyong.
http://www.mkyong.com/android/android-spinner-drop-down-list-example/

I also drew inspiration from source code for apps provided in 
labs (both forks from master branches)

LonelyTwitter: https://github.com/bkhunter/lonelyTwitter
FillerCreep: https://github.com/bkhunter/FillerCreepForAndroid

************************************************************
                   Eclipse Installation
************************************************************

Normal installation should work properly

In appropriate workspace:
--> git clone https://github.com/bkhunter/bkhunter-notes.git
--> open Eclipse
--> import Existing Android code into workspace

Note: Cleaning the project may be necessary

*************************************************************
                      WalkThrough
*************************************************************

The app will open up with a blank screen with a button that
says "Add Claim"

--> Press "Add Claim"

This will open up an activity presenting several textboxes,
a textbox for the claim's name, start-date, end-date,
description

NOTE: It is very important that the dates are entered in the
format specified. The claims will not be sorted otherwise.

--> fill in the required fields (all)

After filling in the fields you will see two buttons

1) Has expense --> allows you to immediately add an expense
to the claim
2) No expense --> takes you back to the start page

--> press the second button

You will now see the claim show up on the start screen.
Should you add more they will also show up.

Claims are sorted by the field Date From

--> Select the claim

a window pops up with options
1) currency: shows total currency amounts for each expense that 
the claim has
2) delete: deletes the Claim
3) View: allows you to view the claim

--> press View

Now you will see the information of the claim displayed

-The claim is defaulted to have an "in-progress" status,
hitting "Change Status" will allow the user to switch

-There is a button "View Claims" that takes you back to the 
main page

-"Edit claim" allows you to edit the Claim with the same fields
that were given when it was created

-"Email claim" allows the user to email the claim
and all of it's constituent expense items

-"View Expense Items" take the user to a page containing all 
Expense Items for that claim

--> press View Expense Items

You will now see an empty page with 2 buttons

-"Add"
-"Back To Claim"

--> Hit "add"

now you can fill in the fields for adding an Expense Item,
which are it's title, date, description, category, currency, and amount

NOTE: It is very important that the amount field be filled, the app cannot
convert an empty string to an integer

--> fill in the fields
--> hit finish

you will now see the Expense_item appear, and should you add more
they will appear as well.

--> Click the expense Item
--> hit view on the prompt

You can now see a description of the Expense item.
Should you wish, you can hit edit which allows the user
to edit the Expense item, or delete it

--> click edit

--> click delete

You will now be taken back to the expense item page, but the
expense you clicked is now gone

--> click back to claims

--> click view claims

--> click on the added claim

--> press Delete.

That's the end of the walkthrough.
************************************************************
************************************************************
