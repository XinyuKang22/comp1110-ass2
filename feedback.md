# Assignment Two Feedback

## Group  tue11v
## Group members: "u6662643","Li","Elton","","u6598700","Zhang","Yinuo","","u6120911","Kang","Xinyu"

## Tutor Comment
You have some self-assessed rules mistakes in single player mode, but you fixed these in the multiplayer mode. You did
however make a small error with special tiles - a special tile may be placed as well as all 4 dice roll tiles.
Half of your code contains really informative comments, but the other half contains no comments at all. I would have liked
to see better use of object oriented features as opposed to doing most of your calculations with the board and placement
strings. You have made really good use of JUnit tests! I hope you discovered how useful these are in debugging your code
and making sure that you cover all cases.
You have a subtle error in getBasicScore that failed an extra test we added post-submission. I could not find the bug in
your test by inspection, but if you're interested in finding it, here is the board string that it failed.
"A3A10B2A31A1B30A0F61A4A21B1B14A4A41A4D61S2A50A5A63A2B01A1C02B0G52S0B63A0E63A2E51A4D51B0C32A5D31A5C61A0E41S5D41B1D03A5B51A4G10A0C42B0G30A2F52A5F12B2F21A0F00"
Overall, really great work on this assignment. Best of luck for your exams!



## Mark

**  7.87/11.0**

## Miscellaneous marks

| Level | Requirement | Result |
|:-:|---|:-:|
||All files correct                     | 0.25/.25 |
||Authorship clear for all classes      | 0.25/.25 |
||Appropriate use of Git                | 0.5/.5  |
||Program runs from JAR                 | 0.25/.25 |
|P|Appropriate use of OO features       | 0/.5  |
|P|Presentation PDF complete            | 0.5/.5  |
|CR|Program well designed               | 0.5/.5  |
|CR|Comments clear and sufficient       | 0.25/.5  |
|CR|Coding style good                   | 0.25/.25 |
|CR|Appropriate use of JUnit tests      | 0.5/.5  |
|D|Design and code of very high quality | 0/.25 |
|D|Demonstrates interesting extensions  | 0/.25 |
|D|Works well and easy to run           | 0/.25 |
|HD|Game is exceptional                 | 0/.5  |

**Total for miscellaneous marks:**  3.25/5.25

## Game marks (manual)

| Level | Requirement | Result |
|:-:|---|:-:|
|CR|Tiles snap into place            | 0.25/.25 |
|CR|Tiles can be rotated and flipped | 0.25/.25 |
|CR|Only valid placements allowed    | 0.25/.25 |
|CR|Basic score at game end          | 0.25/.25 |
|D |Basic computer opponent          | 0.25/.25 |
|HD|Advanced computer opponent       | 0/.5  |

**Total for manual marks:** 1.25/1.75

## Test results

| Task | Test | Result | Marks |
|:-:|---|:-:|:-:|
| |Compiled|.25/.25|.25|
|2|IsTilePlacementWellFormed|3/3|.5|
|3|IsBoardStringWellFormed|6/6|.5|
|5|AreConnectedNeighbours|5/5|.5|
|6|IsValidPlacementSequence|5/5|.5|
|7|GenerateDiceRoll|4/4|.25|
|8|GetBasicScore|3/4|.375|
|10|GenerateMove|5/5|.5|
|12|GetAdvancedScore|0/2|0|

**Total for tests:** 3.37/4.0

## Originality statements

#### Originality statement G
We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work, with the following documented exceptions:

* Methods isTilePlacementWellFormed, isBoardStringWellFormed, areConnectedNeighbours,
  generateDiceRoll, getBasicScore and getAdvancedScore in the original class RailwayInk are 
  used in our skeleton. Part of parameters and return types have been changed to achieve simpler function.

*the ImageView function used in Viewer was taken from a piazza post created by the instructors Ashleigh Johannes and Josh Milthorpe.

* The code in class <Viewer> to draw grids uses an idea suggested by <Olivia Chen>

* The idea of which classes need to be imported to create a test comes from <IsBoardStringWellFormedTest>

* The new images in assets:
        - "dieA.gif" is download from website "http://premium-institute.com/RollingDie.html";
        - "LOGO.png" is download from website "https://www.kisspng.com/png-train-cartoon-train-png-vector-material-276124/download-png.html"
          and mix with pictures in Microsoft word;
        - "round1.png" to "round7.png", "win.png", "lose.png", and "even.png" are purely made using Microsoft word;
        

Signed: Xinyu Kang (u6120911), Yinuo Zhang (u6598700)

#### Originality statement F
We declare that the work we have submitted for Stage F of this assignment is entirely our own work.

Signed: Xinyu Kang (u6120911)

#### Originality statements E
I declare that the work I have submitted for Stage E of this assignment and all stages before it is entirely my own work, with the
following documented exceptions:

* The idea of which classes need to be imported to create a test comes from <IsBoardStringWellFormedTest>

Signed: Xinyu Kang (u6120911)

#### Originality statements D
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work, with the following documented exceptions:

* The code in class <Viewer> to draw grids uses an idea suggested by <Olivia Chen>

Signed: Xinyu Kang (u6120911)

#### Originality statement C
We declare that the work we have submitted for Stage C of this assignment and all stages before it is entirely our own work, with the following documented exceptions:

* Methods isTilePlacementWellFormed, isBoardStringWellFormed, areConnectedNeighbours,
  generateDiceRoll, getBasicScore and getAdvancedScore in the original class RailwayInk are 
  used in our skeleton. Part of parameters and return types have been changed to achieve simpler function.
*the ImageView function used in Viewer was taken from a piazza post created by the instructors Ashleigh Johannes and Josh Milthorpe.

Signed:  Xinyu Kang (u6120911), Elton Li (u6662643), and Yinuo Zhang (u6598700)

#### Originality statement B
We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work, with the following documented exceptions:

* Methods isTilePlacementWellFormed, isBoardStringWellFormed, areConnectedNeighbours,
  generateDiceRoll, getBasicScore and getAdvancedScore in the original class RailwayInk are 
  used in our skeleton. Part of parameters and return types have been changed to achieve simpler function.

Signed:  Xinyu Kang (u6120911), Elton Li (u6662643), and Yinuo Zhang (u6598700)

## Git Log
```
commit dedfd9697f45b3802aa29f021c466ca49d631b62
Author: u6120911 <u6120911@anu.edu.au>
Date:   Fri May 24 04:55:23 2019 +1000

    update authorship

commit d13dde5072284c73192388041832cbd21583f6cb
Author: u6120911 <u6120911@anu.edu.au>
Date:   Fri May 24 04:23:27 2019 +1000

    updated all needed admin files

commit 5ad8f6e8201890a61d0a2651d3726cb273511f66
Author: u6120911 <u6120911@anu.edu.au>
Date:   Fri May 24 03:37:51 2019 +1000

    added some comments

commit edad6067b04c94057c8f6e3c0db086b6baeba8d5
Merge: 91f8279 b7417fe
Author: Rebecca <u6598700@anu.edu.au>
Date:   Fri May 24 03:24:26 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit 91f8279083444e7c011cc1133cdcc2a49d1f0be9
Author: Rebecca <u6598700@anu.edu.au>
Date:   Fri May 24 03:24:02 2019 +1000

    "fixed task 8"

commit b7417fe154a4663f7e11c2226d726687fcb8e551
Author: u6120911 <u6120911@anu.edu.au>
Date:   Fri May 24 00:19:52 2019 +1000

    finished task 11

commit e169628f8aa61827550e3efdda9116eb5c28a696
Author: u6120911 <u6120911@anu.edu.au>
Date:   Fri May 24 00:12:04 2019 +1000

    finished task 11

commit 813355c0c82222770d564ad3378e3834ce20d6b0
Author: Rebecca <u6598700@anu.edu.au>
Date:   Thu May 23 17:23:37 2019 +1000

    "fixed task 10"

commit 4f33e534947260083ba061c50a02d2acb44ee0c4
Merge: 3306cfa 1afe915
Author: Rebecca <u6598700@anu.edu.au>
Date:   Thu May 23 14:30:29 2019 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit 3306cfa117109915ccbe989a55e2489da9d24499
Author: Rebecca <u6598700@anu.edu.au>
Date:   Thu May 23 14:28:36 2019 +1000

    "merge"

commit 1afe915b4dc379af97d7778261dded3c0b9e901a
Author: u6120911 <u6120911@anu.edu.au>
Date:   Thu May 23 14:23:21 2019 +1000

    changed task 6

commit f1a31ef31ac3c19fc87e8eee53e7d96d8399d7be
Author: Rebecca <u6598700@anu.edu.au>
Date:   Thu May 23 13:50:05 2019 +1000

    "Changed task10"

commit a4b6ffbe72117eb02bb825c39b034ab3a77fccda
Author: u6120911 <u6120911@anu.edu.au>
Date:   Thu May 23 10:55:47 2019 +1000

    .

commit ca427fdbf3185cafb6009dec114e4daccf8ab7ee
Merge: a1901f5 8ade67a
Author: u6120911 <u6120911@anu.edu.au>
Date:   Thu May 23 00:59:23 2019 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/RailroadInk.java

commit a1901f54868b8dcb6975d2a2838a393a638b04af
Author: u6120911 <u6120911@anu.edu.au>
Date:   Thu May 23 00:58:28 2019 +1000

    .

commit 8ade67a03c0d9bde180e7479e346cf4f3227b47f
Author: Rebecca <u6598700@anu.edu.au>
Date:   Thu May 23 00:30:55 2019 +1000

    "fixed task7"

commit 6543a2314c7d333bc7ef197108044c87d2eebb76
Author: Rebecca <u6598700@anu.edu.au>
Date:   Thu May 23 00:28:33 2019 +1000

    "fixed task7"

commit 99e88e5a35eb06dc465f39a840c590e7c159f9ae
Merge: c25271b 72b10a5
Author: Rebecca <u6598700@anu.edu.au>
Date:   Thu May 23 00:20:40 2019 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/RailroadInk.java

commit c25271b8bb482690f213d844fbd8e878c0922e6d
Author: Rebecca <u6598700@anu.edu.au>
Date:   Thu May 23 00:18:38 2019 +1000

    "fixed task7"

commit 72b10a52f9d708968aec1debd97c3d69a93a6654
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 22 22:42:30 2019 +1000

    。。

commit 43036b5cdf0d320b637f8f0ec1b0019a5513279b
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 22 21:20:29 2019 +1000

    .

commit 2b5e280ead004a5b2aad759e2f44ccbd324e07bb
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 22 21:18:32 2019 +1000

    updated originality file

commit 3a00399e4ee496c0a18a39c8019e377b8e85fb43
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 22 21:00:54 2019 +1000

    add comments to solo player mode

commit 0c42479bda24d41d4ee2c2ec2394b0e7bf1b0fb8
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 22 19:58:40 2019 +1000

    multiple player almost done

commit 0bfe39623da71f329f0094a3f13ff0014aabab64
Merge: 52c2148 f155104
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 22 18:08:32 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit 52c2148bb7e730cda18bca0f123011c855a3bad0
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 22 18:07:16 2019 +1000

    task 6 correct

commit f1551049fae69e3519fb495ad767e3da23a6f33c
Merge: e427ef9 e694301
Author: Rebecca <u6598700@anu.edu.au>
Date:   Wed May 22 17:30:45 2019 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit e427ef91e8a563d68026e3e827f36ed2c69e9ebd
Author: Rebecca <u6598700@anu.edu.au>
Date:   Wed May 22 17:30:19 2019 +1000

    "update game"

commit e694301da82d181783ebbe1c55bd6d559db4ccbf
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 22 17:22:34 2019 +1000

    ..

commit 6f37b97888fc00001f8970e8974e6fb2c1236b68
Merge: b2e695a 5cc4487
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 22 17:19:46 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit b2e695aefa53f4a457cfd7df4f1f1ed41ede3aaf
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 22 01:12:13 2019 +1000

    .

commit 9805dc38923a1085dd4ff517f08343c9dc165805
Author: Rebecca <u6598700@anu.edu.au>
Date:   Wed May 22 00:11:50 2019 +1000

    "finished task 10"

commit ff138f8c308fa3220441eee16a9c25b73d944786
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 21 20:40:24 2019 +1000

    multiple players skeleton

commit 0130b727f5a75b02097b0e4105c206e82b1e1d7f
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 21 16:20:31 2019 +1000

    multiple players skeleton

commit 49431c5948f54672a1d4ae5f7386fc910f80bd46
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 21 13:48:38 2019 +1000

    made some small changes

commit 632e2642e3a6e1dfc67ff5de84e90d740f02b809
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon May 20 12:21:29 2019 +1000

    Finished task 9

commit 1c3853c89f8c76f0a1573dcdf8b3efd09a9e896a
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon May 20 00:57:21 2019 +1000

    Finished task 9, but getScore() needs to fix

commit c7a9dbabb1e4a575715e36edd2bf567a1480ee89
Author: u6120911 <u6120911@anu.edu.au>
Date:   Sun May 19 22:18:38 2019 +1000

    Added lock function to special tiles

commit 8f53b28f21b75afcf2f4be89f0fc1af1aec72b4e
Author: u6120911 <u6120911@anu.edu.au>
Date:   Sun May 19 11:27:59 2019 +1000

    Change the dice rolling

commit 9f47fc9e7869e8907b6c44927670f44f25ba6382
Author: u6120911 <u6120911@anu.edu.au>
Date:   Sat May 18 00:57:10 2019 +1000

    Add some methods

commit 8d79ddba8d374727c31fa3222f202505f11a1e6a
Author: Rebecca <u6598700@anu.edu.au>
Date:   Fri May 17 19:50:36 2019 +1000

    "finished task 7 and 8"

commit 2dcd40340b2108445675d34427787c1dafb00337
Merge: 03162df 070d44f
Author: Rebecca <u6598700@anu.edu.au>
Date:   Fri May 17 19:47:47 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit 03162df192bb1c8e7867425b5edfc00a7cbc029d
Author: Rebecca <u6598700@anu.edu.au>
Date:   Fri May 17 19:46:00 2019 +1000

    "finished task 7 and 8"

commit 070d44fddf67f588a37919f70a416ca246373277
Author: u6120911 <u6120911@anu.edu.au>
Date:   Fri May 17 13:43:31 2019 +1000

    ..

commit 4b00f632cf716786f6606d6b0721a5226a8db977
Author: u6120911 <u6120911@anu.edu.au>
Date:   Fri May 17 12:24:51 2019 +1000

    .

commit 98939350e06a3ecae774c6103e7f84476bf6a5b1
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 15 21:50:50 2019 +1000

    updated rolling dice

commit 12f00323a791a09f98b35729d61dc84a97e7c58e
Author: u6120911 <u6120911@anu.edu.au>
Date:   Wed May 15 17:17:27 2019 +1000

    Added rolling dice animation

commit 0aba83c4f7f1a81bbb503e835359b867e08f030b
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 14 22:52:03 2019 +1000

    Fixed rotation

commit 944ab3f1d4130a8ecc752fc2f31fa963113fa7cb
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 14 21:40:30 2019 +1000

    correction

commit 181c15ade9947e831725cd156bde01d6b4adba7d
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 14 21:36:58 2019 +1000

    .

commit 576fd4221c9b21931b4bd7a89b3dc740b0d9aecd
Merge: dde73f8 8c3734c
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 14 21:34:02 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit dde73f859875452756b1561f7ebd2920ac7768f8
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 14 21:33:48 2019 +1000

    Added special tiles

commit 8c3734c05d7d4a1765c5e14ad5b5367950cad1e6
Author: u6120911 <lIFELIFE159268>
Date:   Tue May 14 11:44:17 2019 +1000

    .

commit 7bf852df1d48a5e491e87221937c14e7a1587cbe
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon May 13 22:33:25 2019 +1000

    .

commit e5258c6814ec8962f09670facf30369681504477
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon May 13 22:31:56 2019 +1000

    Review

commit 526249343c68e9d853dcb6d3c45adf7870a65914
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon May 13 21:45:33 2019 +1000

    author detail

commit 3509e02cf0a5502034416fb51d8282515cfe963e
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon May 13 20:01:09 2019 +1000

    Updated contribution & originality

commit 4c358951e949e1020ec62e9712e917734409d538
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon May 13 19:54:46 2019 +1000

    Added authorship

commit 8d2092b71dc79d19217fe354182514a1b719d631
Author: u6120911 <u6120911@anu.edu.au>
Date:   Sat May 11 18:12:45 2019 +1000

    Packaged as game.jar

commit 5cc448733278de86218c9944959e10b73d690ea9
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu May 9 00:26:38 2019 +1000

    fix chi-squared test values

commit 83638167f37ebcc8b4ba7857a67b38c1857f9d47
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Wed May 8 09:51:54 2019 +1000

    improve GenerateDiceRollTest to be statistically more rigorous
    
    added more tests for invalid placements due to duplicates

commit f6998e646dc7b8d48abb21808d8c2acdf7141aae
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Wed May 8 08:19:25 2019 +1000

    isValidPlacementSequenceTest: fix and add test for invalid connection
    
    add test for duplicate placements

commit 5f3b00b7c6f7df884b3539108c6624ec7b88de5e
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 7 13:10:38 2019 +1000

    new

commit bac32e33d02dc9274862f2f0ad512183d563bc8a
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 7 11:55:21 2019 +1000

    new

commit b479e33d88219f70f558a853bf0bf1960681ad83
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 7 11:39:34 2019 +1000

    new

commit 792f689929256b1cc47598182a600f5a69175bb9
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 7 11:35:35 2019 +1000

    new

commit 6ebb00f72cf548c9102495bb4df0aad824ab4dee
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue May 7 11:24:16 2019 +1000

    Updated originality file

commit 20f94fc800715ea7183ddbd6f90ebc0fd31459b0
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon May 6 10:50:23 2019 +1000

    remove unused code

commit b953060a4dd8bf37489323395d6cff489c72ced8
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon May 6 10:49:17 2019 +1000

    fix GenerateDiceRollTest.testDieFaces to correctly count dice rolls

commit 07a4c1080bca16820c54a49df31e851814d86089
Author: u6120911 <u6120911@anu.edu.au>
Date:   Fri May 3 23:12:33 2019 +1000

    Add four new tests for class <Board>

commit 6999e2822e839f05bb507ab6045bec007a2bb47a
Author: u6120911 <u6120911@anu.edu.au>
Date:   Fri May 3 23:11:19 2019 +1000

    Corrected one commit

commit 0a6fb6a5a6c1a1d12b8837ec3a05f7122227fa96
Author: u6120911 <u6120911@anu.edu.au>
Date:   Fri May 3 23:02:51 2019 +1000

    Fixed image mirroring

commit 3c79be7fcedbb6815234e9201c757b192155ec85
Author: u6120911 <u6120911@anu.edu.au>
Date:   Thu May 2 12:52:35 2019 +1000

    Add clear button

commit 7fa390fcc96e799cfbf6564847e737d9110e7cdd
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue Apr 30 00:00:37 2019 +1000

    Update originality D2D

commit 4d0c67644de67d0255c1c450b8d012ad664f0724
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon Apr 29 23:54:20 2019 +1000

    Add new statements

commit 8450e3ce4775c8123fd5c73600e3ca71c8a748bf
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon Apr 29 19:37:23 2019 +1000

    Complete Task 4

commit 7ca60c74de7007616a19c4996425746fe95e1cab
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue Apr 2 11:01:10 2019 +1100

    Task 4 skeleton

commit 2042b744290831c44c242585d689c7dcdb4277c1
Merge: 767cc9f 0984a5e
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue Apr 2 10:48:52 2019 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/gui/Viewer.java

commit 767cc9f906fc0f53bdaf4755abce9cd266443eba
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue Apr 2 10:47:03 2019 +1100

    Task 4 to be fixed

commit 0984a5e677a6e6142fe7ffd37a782d917b2611ae
Author: Elton <u6662643@anu.edu.au>
Date:   Tue Apr 2 09:54:43 2019 +1100

    Submitting and doing originality and explanation comments.

commit 8ad7b6a02dee3b0b23996b32b98d16268e6d42ec
Author: Elton <u6662643@anu.edu.au>
Date:   Tue Apr 2 09:32:11 2019 +1100

    Doing Task 4: Need to make viewer + originality for ImageView

commit 330847726dfbc3643e8b099db6c60b065104a0d3
Author: Elton <u6662643@anu.edu.au>
Date:   Tue Apr 2 09:28:14 2019 +1100

    Doing Task 4: Need to make viewer

commit 9cee2b5b00726f2f206ecd616012ddcc36018c90
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Apr 2 09:12:01 2019 +1100

    AreConnectedNeighboursTest: more tests for mirror-asymmetric tiles

commit f5f4e74c0090016a4b0050bb167be96edb46d5bf
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue Apr 2 01:28:10 2019 +1100

    D2C admin files updated

commit 4c27be7dc4695171db6dffefa3c211a1b223ad69
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue Apr 2 01:13:01 2019 +1100

    Add some comments

commit 53e40668e976269f57ef5e6952d03cb845a061ab
Author: Elton <u6662643@anu.edu.au>
Date:   Tue Apr 2 00:31:01 2019 +1100

    Finishing Task 3 but Task 2 still questionable

commit eba8cbb4cbd46777eccf6f41e234d72da7d6600d
Author: Elton <u6662643@anu.edu.au>
Date:   Tue Apr 2 00:30:38 2019 +1100

    Finishing Task 3 but Task 2 still questionable

commit 05196c2ef9b2cd6c2af2b86d3d6d0ba6c660b1a3
Author: Elton <u6662643@anu.edu.au>
Date:   Tue Apr 2 00:29:51 2019 +1100

    Task 2: Needs to be fixed up

commit 58ec2266a76ee8de2928b6db6a463bf5a1c2201c
Author: Elton <u6662643@anu.edu.au>
Date:   Mon Apr 1 19:08:06 2019 +1100

    Task 2: Needs to be fixed up

commit e7794a83cffcc8cffe55bac7d766576de3766e1f
Merge: 012497a d3b7162
Author: u6662643 <u6662643@anu.edu.au>
Date:   Mon Apr 1 17:13:06 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6120911/comp1110-ass2-tue11v

commit d3b716277e5c8c8ebe18ec81558862d8f099abd5
Author: u6120911 <u6120911@anu.edu.au>
Date:   Sun Mar 31 20:35:20 2019 +1100

    Task 6 draft

commit 87ac2d28dad81c8f48aba4f04f7c62a88bbec9e3
Author: Rebecca <u6598700@anu.edu.au>
Date:   Sun Mar 31 17:28:51 2019 +1100

    "passed tests of areConnectedNeighbours"

commit c31ba1ef10ecf073353dddfbfd2bb72343c6c495
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sun Mar 31 08:54:35 2019 +1100

    T10 GenerateMoveTest

commit 5a0302f1af1a21b7302a7be2b7061203f7531b48
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sat Mar 30 22:39:34 2019 +1100

    T8 GetBasicScoreTest, T12 GetAdvancedScoreTest

commit d61559a8eace9eb0de8948899ccf1a333a7a43eb
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sat Mar 30 14:39:59 2019 +1100

    test more types of invalid piece placements

commit b0d3d465e8f50fd8711c3f1601da84278d96ab24
Author: Rebecca <u6598700@anu.edu.au>
Date:   Wed Mar 27 18:19:29 2019 +1100

    "change areConnectedNeighbour"

commit 012497af3014199ac0ab4d40afee704eab0d9474
Author: Bob <u6662643@anu.edu.au>
Date:   Tue Mar 26 12:43:27 2019 +1100

    B

commit 036082d9aa97bc7284a3fc502f11a0d96fb6ac79
Merge: f7d94f0 76000c1
Author: u6662643 <u6662643@anu.edu.au>
Date:   Tue Mar 26 12:33:58 2019 +1100

    Merge remote-tracking branch 'origin/master'

commit 76000c153c0cd20393e6a6d5ca4706b443bd342e
Author: Cindy <u6120911@anu.edu.au>
Date:   Tue Mar 26 12:33:16 2019 +1100

    Part 1 done

commit f7d94f071b2b0b1d4d47b910980ccfabdc77b49e
Author: Bob <u6662643@anu.edu.au>
Date:   Tue Mar 26 12:31:08 2019 +1100

    B

commit 84c1f5b94fd286758ce9385366672357760c7417
Author: Bob <u6662643@anu.edu.au>
Date:   Tue Mar 26 12:30:51 2019 +1100

    B

commit 6cad9297d4ab1883e265f23be410e7e2f6d8572d
Author: u6662643 <u6662643@anu.edu.au>
Date:   Tue Mar 26 12:29:30 2019 +1100

    B

commit 3097b8d65f9680dee447119ca0af831f88ea65f5
Author: Alice <u6120911@aun.edu.au>
Date:   Tue Mar 26 12:26:03 2019 +1100

    Part 1 done

commit ad0e93e0b76a71cd1c9f63193f780bf19e1a7cb1
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue Mar 26 11:40:52 2019 +1100

    Changed upstream

commit ae19f322409389ea68088e6242d0dc00fc1027c4
Merge: 5c0f2b9 87f0a67
Author: u6120911 <u6120911@anu.edu.au>
Date:   Tue Mar 26 11:37:47 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 5c0f2b9c2251477f0920c1caea9d9b34618188b4
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon Mar 25 22:33:18 2019 +1100

    Updated B-originality

commit 34a04a95db3829a691fe343b9ceffe2dc9a7f4ca
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon Mar 25 22:30:36 2019 +1100

    Updated B-contribution and B-originality

commit 783fc8fd421bc575076889bd4326e6dc16618e03
Author: u6120911 <u6120911@anu.edu.au>
Date:   Mon Mar 25 19:19:00 2019 +1100

    Stage B draft_1

commit 87f0a67a1ea2b01ea570f9cbe66f23eacfe13a1c
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Mar 22 16:57:27 2019 +1100

    fix off-by-one errors in Javadoc spec

commit 6899cf1bfb33883edba7d29b261aa2e63950d6be
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu Mar 21 21:40:31 2019 +1100

    fix specification for dice roll - B can only roll 0-2
    
    fix IsTilePlacementWellFormedTest and GenerateDiceRollTest accordingly

commit 033553d235a2587a19ee985fcc8e983fa0658604
Author: Xinyu Kang <u6120911@anu.edu.au>
Date:   Tue Mar 19 12:20:35 2019 +1100

    Update tasks.md

commit bb9f498a4456c2ddd13c088f4438b768ef249bdf
Author: Xinyu Kang <u6120911@anu.edu.au>
Date:   Tue Mar 19 12:19:10 2019 +1100

    Update tasks.md

commit 984e9fef1b9f26e2d4f38cf136ad5e85b4a9a6cd
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 19 02:08:41 2019 +1100

    assignment published
```
## Changes
``` diff
diff -ru -x .git ../master/comp1110-ass2/admin/B-contribution.md comp1110-ass2/admin/B-contribution.md
--- ../master/comp1110-ass2/admin/B-contribution.md	2019-05-24 13:59:03.704392235 +1000
+++ comp1110-ass2/admin/B-contribution.md	2019-05-24 17:08:21.611545514 +1000
@@ -1,7 +1,7 @@
 We declare that the work toward our submission of Stage B was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u6120911 34
+* u6662643 33
+* u6598700 33
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: Xinyu Kang (u6120911), Elton Li (u6662643), and Yinuo Zhang (u6598700)
diff -ru -x .git ../master/comp1110-ass2/admin/B-originality.md comp1110-ass2/admin/B-originality.md
--- ../master/comp1110-ass2/admin/B-originality.md	2019-05-24 13:59:03.724392356 +1000
+++ comp1110-ass2/admin/B-originality.md	2019-05-24 17:08:21.631545657 +1000
@@ -1,9 +1,7 @@
 We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
+* Methods isTilePlacementWellFormed, isBoardStringWellFormed, areConnectedNeighbours,
+  generateDiceRoll, getBasicScore and getAdvancedScore in the original class RailwayInk are 
+  used in our skeleton. Part of parameters and return types have been changed to achieve simpler function.
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed:  Xinyu Kang (u6120911), Elton Li (u6662643), and Yinuo Zhang (u6598700)
diff -ru -x .git ../master/comp1110-ass2/admin/C-contribution.md comp1110-ass2/admin/C-contribution.md
--- ../master/comp1110-ass2/admin/C-contribution.md	2019-05-24 13:59:03.740392452 +1000
+++ comp1110-ass2/admin/C-contribution.md	2019-05-24 17:08:21.655545828 +1000
@@ -1,7 +1,7 @@
 We declare that the work toward our submission of Stage C was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u6120911 40
+* u6662643 30
+* u6598700 30
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: Xinyu Kang (u6120911), Elton Li (u6662643), and Yinuo Zhang (u6598700)
diff -ru -x .git ../master/comp1110-ass2/admin/C-originality.md comp1110-ass2/admin/C-originality.md
--- ../master/comp1110-ass2/admin/C-originality.md	2019-05-24 13:59:03.768392620 +1000
+++ comp1110-ass2/admin/C-originality.md	2019-05-24 17:08:21.671545942 +1000
@@ -1,9 +1,8 @@
 We declare that the work we have submitted for Stage C of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
+* Methods isTilePlacementWellFormed, isBoardStringWellFormed, areConnectedNeighbours,
+  generateDiceRoll, getBasicScore and getAdvancedScore in the original class RailwayInk are 
+  used in our skeleton. Part of parameters and return types have been changed to achieve simpler function.
+*the ImageView function used in Viewer was taken from a piazza post created by the instructors Ashleigh Johannes and Josh Milthorpe.
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed:  Xinyu Kang (u6120911), Elton Li (u6662643), and Yinuo Zhang (u6598700)
Only in ../master/comp1110-ass2/admin: D-originality-u1234567.md
Only in comp1110-ass2/admin: D-originality-u6120911.md
Only in ../master/comp1110-ass2/admin: E-originality-u1234567.md
Only in comp1110-ass2/admin: E-originality-u6120911.md
diff -ru -x .git ../master/comp1110-ass2/admin/F-contribution.md comp1110-ass2/admin/F-contribution.md
--- ../master/comp1110-ass2/admin/F-contribution.md	2019-05-24 13:59:03.852393125 +1000
+++ comp1110-ass2/admin/F-contribution.md	2019-05-24 17:08:21.719546284 +1000
@@ -1,8 +1,7 @@
 We declare that the work toward our submission of Stage F was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
+* u6120911 50
+* u6598700 50
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Xinyu Kang (u6120911), Yinuo Zhang (u6598700)
 
diff -ru -x .git ../master/comp1110-ass2/admin/F-originality.md comp1110-ass2/admin/F-originality.md
--- ../master/comp1110-ass2/admin/F-originality.md	2019-05-24 13:59:03.884393317 +1000
+++ comp1110-ass2/admin/F-originality.md	2019-05-24 17:08:21.747546484 +1000
@@ -1,9 +1,3 @@
-We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage F of this assignment is entirely our own work.
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
-
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-* ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Xinyu Kang (u6120911)
Only in ../master/comp1110-ass2/admin: F-review-u1234567.md
Only in comp1110-ass2/admin: F-review-u6120911.md
Only in ../master/comp1110-ass2/admin: G-best-u1234567.md
Only in comp1110-ass2/admin: G-best-u6120911.md
diff -ru -x .git ../master/comp1110-ass2/admin/G-contribution.md comp1110-ass2/admin/G-contribution.md
--- ../master/comp1110-ass2/admin/G-contribution.md	2019-05-24 13:59:04.000394015 +1000
+++ comp1110-ass2/admin/G-contribution.md	2019-05-24 17:08:21.827547055 +1000
@@ -1,8 +1,8 @@
 We declare that the work toward our submission of Stage G was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
+* u6120911 50
+* u6598700 50
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+
+Signed: Xinyu Kang (u6120911), Yinuo Zhang (u6598700)
 
diff -ru -x .git ../master/comp1110-ass2/admin/G-features.md comp1110-ass2/admin/G-features.md
--- ../master/comp1110-ass2/admin/G-features.md	2019-05-24 13:59:04.028394183 +1000
+++ comp1110-ass2/admin/G-features.md	2019-05-24 17:08:21.847547197 +1000
@@ -3,11 +3,11 @@
 
 *(Remove those that are unimplemented)*
 
- - A simple placement viewer (Task 4)
- - A basic playable game
- - A basic playable game that snaps pieces to the board and checks for validity (Task 7)
- - Generates basic starting piece placements (Task 8)
- - Implements hints (Task 10)
- - Implements interesting starting placements (Task 11)
+ X A simple placement viewer (Task 4)
+ X A basic playable game
+ X A basic playable game that snaps pieces to the board and checks for validity (Task 7)
+ X Generates basic starting piece placements (Task 8)
+ X Implements hints (Task 10)
+ X Implements interesting starting placements (Task 11)
 
 additional features...
diff -ru -x .git ../master/comp1110-ass2/admin/G-originality.md comp1110-ass2/admin/G-originality.md
--- ../master/comp1110-ass2/admin/G-originality.md	2019-05-24 13:59:04.048394304 +1000
+++ comp1110-ass2/admin/G-originality.md	2019-05-24 17:08:21.875547397 +1000
@@ -1,9 +1,20 @@
 We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
+* Methods isTilePlacementWellFormed, isBoardStringWellFormed, areConnectedNeighbours,
+  generateDiceRoll, getBasicScore and getAdvancedScore in the original class RailwayInk are 
+  used in our skeleton. Part of parameters and return types have been changed to achieve simpler function.
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
+*the ImageView function used in Viewer was taken from a piazza post created by the instructors Ashleigh Johannes and Josh Milthorpe.
 
-* ....
+* The code in class <Viewer> to draw grids uses an idea suggested by <Olivia Chen>
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+* The idea of which classes need to be imported to create a test comes from <IsBoardStringWellFormedTest>
+
+* The new images in assets:
+        - "dieA.gif" is download from website "http://premium-institute.com/RollingDie.html";
+        - "LOGO.png" is download from website "https://www.kisspng.com/png-train-cartoon-train-png-vector-material-276124/download-png.html"
+          and mix with pictures in Microsoft word;
+        - "round1.png" to "round7.png", "win.png", "lose.png", and "even.png" are purely made using Microsoft word;
+        
+
+Signed: Xinyu Kang (u6120911), Yinuo Zhang (u6598700)
diff -ru -x .git ../master/comp1110-ass2/admin/tasks.md comp1110-ass2/admin/tasks.md
--- ../master/comp1110-ass2/admin/tasks.md	2019-05-24 13:59:04.120394737 +1000
+++ comp1110-ass2/admin/tasks.md	2019-05-24 17:08:21.959547996 +1000
@@ -4,8 +4,9 @@
 Use the entries below as an example.
 
 ## Week 4
-
-Everyone: create application skeleton - meeting 14:00 17 Aug
+Members: Xinyu Kang      Elton Li      Yinuo Zhang
+Uids:    u6120911        u6662643      u6598700
+Weekly Meeting Time: Sat 1pm
 
 ## Week 5
 
diff -ru -x .git ../master/comp1110-ass2/comp1110-ass2.iml comp1110-ass2/comp1110-ass2.iml
--- ../master/comp1110-ass2/comp1110-ass2.iml	2019-05-24 13:59:04.500397021 +1000
+++ comp1110-ass2/comp1110-ass2.iml	2019-05-24 17:08:22.359550850 +1000
@@ -3,12 +3,12 @@
   <component name="NewModuleRootManager" inherit-compiler-output="true">
     <exclude-output />
     <content url="file://$MODULE_DIR$">
-      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
       <sourceFolder url="file://$MODULE_DIR$/tests" isTestSource="true" />
+      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
     </content>
     <orderEntry type="inheritedJdk" />
     <orderEntry type="sourceFolder" forTests="false" />
-    <orderEntry type="module-library" scope="TEST">
+    <orderEntry type="module-library" exported="" scope="TEST">
       <library name="JUnit4">
         <CLASSES>
           <root url="jar://$APPLICATION_HOME_DIR$/lib/junit-4.12.jar!/" />
@@ -18,6 +18,6 @@
         <SOURCES />
       </library>
     </orderEntry>
-    <orderEntry type="library" name="javafx" level="project" />
+    <orderEntry type="library" exported="" name="javafx" level="project" />
   </component>
 </module>
\ No newline at end of file
Only in comp1110-ass2: feedback.md
Only in comp1110-ass2: game.jar
Only in comp1110-ass2/.idea: artifacts
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/T2_IsTilePlacementWellFormedTest.xml comp1110-ass2/.idea/runConfigurations/T2_IsTilePlacementWellFormedTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/T2_IsTilePlacementWellFormedTest.xml	2019-05-24 13:59:03.500391008 +1000
+++ comp1110-ass2/.idea/runConfigurations/T2_IsTilePlacementWellFormedTest.xml	2019-05-24 17:08:21.407544059 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.gui.*" />
+        <option name="PATTERN" value="comp1110.ass2.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
@@ -16,4 +16,4 @@
       <option name="Make" enabled="true" />
     </method>
   </configuration>
-</component>
+</component>
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Viewer.xml comp1110-ass2/.idea/runConfigurations/Viewer.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Viewer.xml	2019-05-24 13:59:03.664391995 +1000
+++ comp1110-ass2/.idea/runConfigurations/Viewer.xml	2019-05-24 17:08:21.563545171 +1000
@@ -5,7 +5,7 @@
     <option name="VM_PARAMETERS" value="-ea --module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.media" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.gui.*" />
+        <option name="PATTERN" value="comp1110.ass2.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
@@ -13,4 +13,4 @@
       <option name="Make" enabled="true" />
     </method>
   </configuration>
-</component>
+</component>
\ No newline at end of file
Only in comp1110-ass2: presentation.pdf
Only in comp1110-ass2/src/comp1110/ass2: gittest
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: dieA.gif
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: even.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: LOGO.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: lose.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: round1.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: round2.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: round3.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: round4.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: round5.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: round6.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: round7.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: win.png
Only in comp1110-ass2/src/comp1110/ass2/gui: Board.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Board.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer$DraggableTile.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer$Grid.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java comp1110-ass2/src/comp1110/ass2/gui/Viewer.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2019-05-24 13:59:04.616397720 +1000
+++ comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2019-05-24 17:08:24.027562747 +1000
@@ -1,70 +1,887 @@
 package comp1110.ass2.gui;
 
+import comp1110.ass2.MultiplePlayers;
+import javafx.animation.KeyFrame;
+import javafx.animation.Timeline;
 import javafx.application.Application;
 import javafx.scene.Group;
 import javafx.scene.Scene;
+import javafx.scene.control.Alert;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
-import javafx.scene.layout.HBox;
+import javafx.scene.image.Image;
+import javafx.scene.image.ImageView;
+import javafx.scene.layout.*;
+import javafx.scene.paint.Color;
+import javafx.scene.shape.Rectangle;
+import javafx.scene.text.Text;
 import javafx.stage.Stage;
+import comp1110.ass2.RailroadInk;
+import javafx.util.Duration;
+import java.util.ArrayList;
+import java.util.HashMap;
+import static javafx.scene.paint.Color.*;
 
 /**
- * A very simple viewer for tile placements in the Railroad Ink game.
- * <p>
- * NOTE: This class is separate from your main game class.  This
- * class does not play a game, it just illustrates various tile placements.
+ * @author Xinyu Kang
  */
 public class Viewer extends Application {
-    /* board layout */
-    private static final int VIEWER_WIDTH = 1024;
-    private static final int VIEWER_HEIGHT = 768;
 
+    private static final int VIEWER_WIDTH = 1024;
+    private static final int VIEWER_HEIGHT = 640;
     private static final String URI_BASE = "assets/";
-
-    private final Group root = new Group();
+    public static Group root = new Group();
+    public static Group begin = new Group();
+    private final Group board = new Group();
     private final Group controls = new Group();
-    TextField textField;
+    private final Group special = new Group();
+    private final Group placementGroup =new Group();
+    private final Group dice =new Group();
+    private final Group roundButton = new Group();
+    private final Group tile = new Group();
+    private final Group alert = new Group();
+    private final Group stringShow = new Group();
+    private final Group round = new Group();
+    private int roundNum = 1;
+    String boardString = "";
+    private ArrayList<DraggableTile> moveTileRecord = new ArrayList<>();
+    private DraggableTile tileS0 = new DraggableTile("S0",700,150,this);
+    private DraggableTile tileS1 = new DraggableTile("S1",700+75,150,this);
+    private DraggableTile tileS2 = new DraggableTile("S2",700+75*2,150,this);
+    private DraggableTile tileS3 = new DraggableTile("S3",700,150+75,this);
+    private DraggableTile tileS4 = new DraggableTile("S4",700+75,150+75,this);
+    private DraggableTile tileS5 = new DraggableTile("S5",700+75*2,150+75,this);
+    private ArrayList<DraggableTile> availableSpecial = new ArrayList<>();
+    private Group specialTiles = new Group();
+    private int remainingSpecial = 6;
+    private int countDice = 0;
+    private DraggableTile tileMoved;
+    private DraggableTile specialMoved = null;
+    private Group specialPictures = new Group();
+    private Group tiles = new Group();
 
-    /**
-     * Draw a placement in the window, removing any previously drawn one
-     *
-     * @param placement A valid placement string
-     */
-    void makePlacement(String placement) {
-        // FIXME Task 4: implement the simple placement viewer
+    @Override
+    public void start(Stage primaryStage) throws Exception {   //start the game
+        primaryStage.setTitle("Railroad Ink");
+        Scene scene = new Scene(root, VIEWER_WIDTH,VIEWER_HEIGHT, Color.BEIGE);
+        root.getChildren().add(board);
+        root.getChildren().add(controls);
+        root.getChildren().add(placementGroup);
+        root.getChildren().add(special);
+        root.getChildren().add(round);
+        root.getChildren().add(tile);
+        root.getChildren().add(alert);
+        root.getChildren().add(dice);
+        root.getChildren().add(begin);
+        root.getChildren().add(stringShow);
+        root.getChildren().add(tiles);
+        displayBeginPage();
+        primaryStage.setScene(scene);
+        primaryStage.show();
+    }
+
+
+    void displayBeginPage(){   // begin page with game logo and three game options
+
+        //set up the logo
+        ImageView logo = new ImageView(Viewer.class.getResource(URI_BASE+"LOGO.png").toString());
+        logo.setFitWidth(900);
+        logo.setFitHeight(700);
+        logo.setLayoutX(0);
+        logo.setLayoutY(0);
+
+        //set up the single player mode
+        Button start  = new Button("SOLO game");
+        start.setLayoutX(800);
+        start.setLayoutY(450);
+        start.setOnMousePressed(event ->{
+            displayRollingArea();
+            initRollingArea();
+            displayBoard();
+            begin.getChildren().clear();
+            initSpecials();
+            startRound();
+        });
+
+        //set up the battle mode (with a computer opponent)
+        Button startMul = new Button("Against Computer ! ");
+        startMul.setLayoutX(800);
+        startMul.setLayoutY(500);
+        startMul.setOnMousePressed(e -> {
+            root.getChildren().remove(begin);
+            MultiplePlayers.mulStart();
+        });
+
+        //set up the viewer mode (task 4)
+        Button view = new Button("Placement Viewer");
+        view.setLayoutX(800);
+        view.setLayoutY(550);
+        view.setOnMousePressed(event ->{
+            inputArea();
+            displayBoard();
+            begin.getChildren().clear();
+        });
+
+        begin.getChildren().add(start);
+        begin.getChildren().add(view);
+        begin.getChildren().add(startMul);
+        begin.getChildren().add(logo);
+
+    }
+
+    // start a new round
+    private void startRound(){
+        if(roundNum==8){
+            finishGame();
+        }else {
+            //create a new round animation
+            ImageView imageView = new ImageView();
+            Image theRound = new Image(Viewer.class.getResource(URI_BASE+"round"+roundNum+".png").toString());
+            Timeline timeline = new Timeline(   new KeyFrame(
+                    Duration.ZERO,
+                    e -> {imageView.setImage(theRound);
+                        imageView.setFitHeight(300);
+                        imageView.setFitWidth(700);
+                        imageView.setLayoutX(150);
+                        imageView.setLayoutY(110);}
+            ),
+                    new KeyFrame(Duration.millis(1000)));
+            timeline.setOnFinished(e -> round.getChildren().clear());
+            timeline.play();
+            round.getChildren().add(imageView);
+
+            //create a round reminder button
+            Button roundReminder = new Button("Round: "+roundNum);
+            roundReminder.setLayoutX(650);
+            roundReminder.setLayoutY(20);
+            Button boardStringViewer = new Button("Click to view score");
+            boardStringViewer.setLayoutX(810);
+            boardStringViewer.setLayoutY(20);
+            boardStringViewer.setOnMousePressed(e -> {
+                Alert alert = new Alert(Alert.AlertType.INFORMATION);
+                alert.setHeaderText(boardString+",   score: "+RailroadInk.getBasicScore(boardString));
+                alert.showAndWait();
+            });
+            roundButton.getChildren().add(roundReminder);
+            roundButton.getChildren().add(boardStringViewer);
+            countDice=0;
+        }
+    }
+
+    //set up the board and the "back" button
+    private void displayBoard() {
+        //set up a 7*7 board
+        for(int i=0; i<7; i++){
+            for(int m=0; m<7; m++){
+                board.getChildren().add(new Grid(150+i*65,100+m*65,65));
+            }
+        }
+
+        board.getChildren().add(roundButton);
+
+        //set up a back button to back to the begin page
+        Button back = new Button("Back");
+        back.setLayoutX(20);
+        back.setLayoutY(20);
+        back.setOnMousePressed(e -> {  //reset all
+            controls.getChildren().clear();
+            placementGroup.getChildren().clear();
+            board.getChildren().clear();
+            special.getChildren().clear();
+            dice.getChildren().clear();
+            stringShow.getChildren().clear();
+            roundButton.getChildren().clear();
+            tile.getChildren().clear();
+            alert.getChildren().clear();
+            boardString = "";
+            availableSpecial.clear();
+            remainingSpecial=6;
+            roundNum=1;
+            countDice=0;
+            moveTileRecord.clear();
+            tiles.getChildren().clear();
+            specialTiles.getChildren().clear();
+            specialMoved=null;
+            tileMoved=null;
+            displayBeginPage();
+        });
+        board.getChildren().add(back);
+        initExits();
+    }
+
+    // to finish the game and show the final result
+    private void finishGame(){
+        special.getChildren().clear();
+        int basicScore = RailroadInk.getBasicScore(boardString);
+
+        //set up an alert to remind player the game is finished
+        Alert alert = new Alert(Alert.AlertType.INFORMATION);
+        alert.setTitle("You have finished the game!!");
+        alert.setHeaderText("Your basic score is:  "+basicScore);
+        alert.showAndWait();
+        Button score = new Button("Your basic score is :    "+basicScore);
+        score.setLayoutX(750);
+        score.setLayoutY(500);
+
+        //when alert is gone, help to view the final basic score
+        Text t = new Text();
+        t.setText("GOOD JOB! ");
+        t.setX(750);
+        t.setY(550);
+        t.setFill(RED);
+        special.getChildren().add(score);
+        special.getChildren().add(t);
+    }
+
+    //return all special tiles pictures
+    private ArrayList<ImageView> specialPics(){
+        ArrayList<ImageView> toReturn = new ArrayList<>();
+        DraggableTile[] a = {tileS0, tileS1, tileS2, tileS3, tileS4, tileS5};
+        for(DraggableTile tile:a){
+            int i = Integer.parseInt(tile.tileName.substring(1,2));
+            ImageView imageView = new ImageView(Viewer.class.getResource(URI_BASE+tile.tileName+".png").toString());
+            imageView.setFitHeight(65);
+            imageView.setFitWidth(65);
+            if(i<3){
+                imageView.setLayoutX(700+i*75);
+                imageView.setLayoutY(150);
+            }else {
+                imageView.setLayoutX(700+(i-3)*75);
+                imageView.setLayoutY(150+75);
+            }
+            imageView.setOnMouseClicked(e -> {
+                Alert alert = new Alert(Alert.AlertType.INFORMATION);
+                alert.setHeaderText("This special tile is locked. ");
+                alert.showAndWait();
+            });
+            toReturn.add(imageView);
+        }
+        return toReturn;
+    }
+
+    //return all special pictures expect the one clicked
+    private ArrayList<ImageView> specialImages(DraggableTile tileClicked){
+        ArrayList<ImageView> toReturn = new ArrayList<>();
+        for(DraggableTile tile:availableSpecial){
+            if(!tile.tileName.equals(tileClicked.tileName)){
+                int i = Integer.parseInt(tile.tileName.substring(1,2));
+                ImageView imageView = new ImageView(Viewer.class.getResource(URI_BASE+tile.tileName+".png").toString());
+                imageView.setFitHeight(65);
+                imageView.setFitWidth(65);
+                if(i<3){
+                    imageView.setLayoutX(700+i*75);
+                    imageView.setLayoutY(150);
+                }else {
+                    imageView.setLayoutX(700+(i-3)*75);
+                    imageView.setLayoutY(150+75);
+                }
+                imageView.setOnMouseClicked(e -> {
+                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
+                    alert.setHeaderText("This special tile is locked. ");
+                    alert.showAndWait();
+                });
+                toReturn.add(imageView);
+            }
+        }
+        return toReturn;
+    }
+
+    //create a frame for the dices
+    //not the simplest way to create a frame, a better choice showed in class MultiplePlayers
+    void initRollingArea(){
+        Rectangle rectangle1 = new Rectangle();
+        rectangle1.setHeight(10);
+        rectangle1.setWidth(75*4+10);
+        rectangle1.setX(700-10);
+        rectangle1.setY(400-10);
+        Rectangle rectangle2 = new Rectangle();
+        rectangle2.setHeight(10);
+        rectangle2.setWidth(75*4+10);
+        rectangle2.setX(700-10);
+        rectangle2.setY(400+65);
+        Rectangle rectangle3 = new Rectangle();
+        rectangle3.setHeight(65+20);
+        rectangle3.setWidth(10);
+        rectangle3.setX(700-10);
+        rectangle3.setY(400-10);
+        Rectangle rectangle4 = new Rectangle();
+        rectangle4.setHeight(65+20);
+        rectangle4.setWidth(10);
+        rectangle4.setX(700+65);
+        rectangle4.setY(400-10);
+        Rectangle rectangle5 = new Rectangle();
+        rectangle5.setHeight(65+20);
+        rectangle5.setWidth(10);
+        rectangle5.setX(700+75*2-10);
+        rectangle5.setY(400-10);
+        Rectangle rectangle6 = new Rectangle();
+        rectangle6.setHeight(65+20);
+        rectangle6.setWidth(10);
+        rectangle6.setX(700+75*3-10);
+        rectangle6.setY(400-10);
+        Rectangle rectangle7 = new Rectangle();
+        rectangle7.setHeight(65+20);
+        rectangle7.setWidth(10);
+        rectangle7.setX(700+75*4-10);
+        rectangle7.setY(400-10);
+        special.getChildren().addAll(rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7);
+    }
+
+
+    //display special tiles' images, set up important buttons in each time dice rolling
+    void displayRollingArea(){
+
+        //display special tiles
+        for(ImageView specialPic:specialPics()){
+            specialPictures.getChildren().add(specialPic);
+        }
+        special.getChildren().add(specialPictures);
+
+        //add a button to roll the dice
+        Button roll = new Button("Roll");
+        roll.setLayoutX(750);
+        roll.setLayoutY(500);
+        roll.setOnMousePressed(event -> {  //when press "roll", show the dice rolling gif
+            ImageView theDice = new ImageView(Viewer.class.getResource(URI_BASE+"dieA.gif").toString());
+            theDice.setFitWidth(65);
+            theDice.setFitHeight(65);
+            theDice.setLayoutX(700+countDice*75);
+            theDice.setLayoutY(400);
+            dice.getChildren().add(theDice);
+        });
+
+        //add a button to stop rolling dice, and get a normal draggable tile
+        Button stop = new Button("Stop");
+        stop.setLayoutX(750+75*2);
+        stop.setLayoutY(500);
+        stop.setOnMousePressed(event -> {
+            dice.getChildren().clear();
+            String diceResult = RailroadInk.generateDiceRoll();
+            //tileMoved record the tile get and need to be placed
+            tileMoved = new DraggableTile(diceResult.substring(countDice*2,countDice*2+2),700+countDice*75,400,this);
+            tile.getChildren().add(tileMoved);
+            countDice++;
+
+            //add a button for player to exchange given normal tile for a special tile
+            // properties of available special tiles are assigned in inner class DraggableTile
+            Button useSpecial = new Button("Change to use special tiles");
+            useSpecial.setLayoutX(700+150);
+            useSpecial.setLayoutY(560);
+            useSpecial.setOnMousePressed(e -> {
+                tile.getChildren().remove(tileMoved);  //clear the given normal tile
+                special.getChildren().remove(specialPictures);
+                tiles.getChildren().add(specialTiles);
+                board.getChildren().remove(useSpecial);
+            });
+
+            //add a button for player to check the whether the placement is valid
+            //if not valid, give an alert; if valid, make the placement on board
+            Button makePlacement = new Button("Make Placement ! ");
+            makePlacement.setLayoutX(700);
+            makePlacement.setLayoutY(560);
+            makePlacement.setOnMousePressed(e ->{
+                String placementString;
+                if(specialMoved==null){  //placed a normal tile
+                    placementString = tileMoved.getPlacementString();
+                    if(RailroadInk.isValidPlacementSequence(boardString+placementString) &&!Board.isOverlap(placementString,boardString)){
+                        makePlacement(placementString);
+                        tile.getChildren().remove(tileMoved);
+                        special.getChildren().add(roll);
+                        special.getChildren().add(stop);
+                        board.getChildren().remove(useSpecial);
+                        board.getChildren().remove(makePlacement);
+                        boardString=boardString+placementString;
+                        specialMoved=null;
+                        if(countDice==4){  //when roll the dice four times, enter the next round
+                            roundNum++;
+                            startRound();
+                        }
+                    }else {
+                        tileMoved.alertError();
+                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
+                        alert.headerTextProperty().set("Invalid Placement!!");
+                        alert.showAndWait();
+                    }
+                }else {  //placed a special tile
+                    placementString = specialMoved.getPlacementString();
+                    if(RailroadInk.isValidPlacementSequence(boardString+placementString)&&!Board.isOverlap(placementString,boardString)){
+                        makePlacement(placementString);
+                        availableSpecial.remove(specialMoved);
+                        specialTiles.getChildren().remove(specialMoved);
+                        special.getChildren().remove(specialMoved);
+                        special.getChildren().add(roll);
+                        special.getChildren().add(stop);
+                        board.getChildren().remove(useSpecial);
+                        board.getChildren().remove(makePlacement);
+                        boardString=boardString+placementString;
+                        specialMoved=null;
+                        remainingSpecial--;
+                        if(remainingSpecial<=3){  //when used up three special tiles, player cannot use more special tiles
+                            specialTiles.getChildren().clear();
+                            specialPictures.getChildren().clear();
+                            availableSpecial.clear();
+                        }
+                        if(countDice==4){
+                            roundNum++;
+                            startRound();
+                        }
+                    }else {
+                        DraggableTile a = specialMoved;
+                        special.getChildren().remove(specialPictures);
+                        special.getChildren().remove(specialMoved);
+                        specialTiles.getChildren().add(a);
+                        a.backToOrigin();
+                        tiles.getChildren().add(specialTiles);
+                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
+                        alert.headerTextProperty().set("Invalid Special Placement!!");
+                        alert.showAndWait();
+                        specialMoved=null;
+                    }
+
+                }
+            });
+
+            board.getChildren().add(makePlacement);
+            special.getChildren().remove(roll);
+            special.getChildren().remove(stop);
+            if(remainingSpecial>3){
+                board.getChildren().add(useSpecial);
+            }
+        });
+        special.getChildren().addAll(roll,stop);
+    }
+
+    //set up special tiles
+    void initSpecials(){
+        availableSpecial.add(tileS0);
+        availableSpecial.add(tileS1);
+        availableSpecial.add(tileS2);
+        availableSpecial.add(tileS3);
+        availableSpecial.add(tileS4);
+        availableSpecial.add(tileS5);
+
+        specialTiles.getChildren().add(tileS0);
+        specialTiles.getChildren().add(tileS1);
+        specialTiles.getChildren().add(tileS2);
+        specialTiles.getChildren().add(tileS3);
+        specialTiles.getChildren().add(tileS4);
+        specialTiles.getChildren().add(tileS5);
+    }
+
+    //set up exits
+    void initExits(){
+        ImageView exitB0 = new ImageView();
+        exitB0.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
+        exitB0.setFitHeight(65);
+        exitB0.setFitWidth(65);
+        exitB0.setLayoutX(150-65);
+        exitB0.setLayoutY(100+65);
+        exitB0.setRotate(270);
+        board.getChildren().add(exitB0);
+
+        ImageView exitD0 = new ImageView();
+        exitD0.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
+        exitD0.setFitHeight(65);
+        exitD0.setFitWidth(65);
+        exitD0.setLayoutX(150-65);
+        exitD0.setLayoutY(100+65*3);
+        exitD0.setRotate(270);
+        board.getChildren().add(exitD0);
+
+        ImageView exitF0 = new ImageView();
+        exitF0.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
+        exitF0.setFitHeight(65);
+        exitF0.setFitWidth(65);
+        exitF0.setLayoutX(150-65);
+        exitF0.setLayoutY(100+65*5);
+        exitF0.setRotate(270);
+        board.getChildren().add(exitF0);
+
+        ImageView exitB6 = new ImageView();
+        exitB6.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
+        exitB6.setFitHeight(65);
+        exitB6.setFitWidth(65);
+        exitB6.setLayoutX(150+65*7);
+        exitB6.setLayoutY(100+65);
+        exitB6.setRotate(90);
+        board.getChildren().add(exitB6);
+
+        ImageView exitD6 = new ImageView();
+        exitD6.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
+        exitD6.setFitHeight(65);
+        exitD6.setFitWidth(65);
+        exitD6.setLayoutX(150+65*7);
+        exitD6.setLayoutY(100+65*3);
+        exitD6.setRotate(90);
+        board.getChildren().add(exitD6);
+
+        ImageView exitF6 = new ImageView();
+        exitF6.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
+        exitF6.setFitHeight(65);
+        exitF6.setFitWidth(65);
+        exitF6.setLayoutX(150+65*7);
+        exitF6.setLayoutY(100+65*5);
+        exitF6.setRotate(90);
+        board.getChildren().add(exitF6);
+
+        ImageView exitA1 = new ImageView();
+        exitA1.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
+        exitA1.setFitHeight(65);
+        exitA1.setFitWidth(65);
+        exitA1.setLayoutX(150+65);
+        exitA1.setLayoutY(100-65);
+        board.getChildren().add(exitA1);
+
+        ImageView exitA3 = new ImageView();
+        exitA3.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
+        exitA3.setFitHeight(65);
+        exitA3.setFitWidth(65);
+        exitA3.setLayoutX(150+65*3);
+        exitA3.setLayoutY(100-65);
+        board.getChildren().add(exitA3);
+
+        ImageView exitA5 = new ImageView();
+        exitA5.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
+        exitA5.setFitHeight(65);
+        exitA5.setFitWidth(65);
+        exitA5.setLayoutX(150+65*5);
+        exitA5.setLayoutY(100-65);
+        board.getChildren().add(exitA5);
+
+        ImageView exitG1 = new ImageView();
+        exitG1.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
+        exitG1.setRotate(180);
+        exitG1.setFitHeight(65);
+        exitG1.setFitWidth(65);
+        exitG1.setLayoutX(150+65);
+        exitG1.setLayoutY(100+65*7);
+        board.getChildren().add(exitG1);
+
+        ImageView exitG3 = new ImageView();
+        exitG3.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
+        exitG3.setRotate(180);
+        exitG3.setFitHeight(65);
+        exitG3.setFitWidth(65);
+        exitG3.setLayoutX(150+65*3);
+        exitG3.setLayoutY(100+65*7);
+        board.getChildren().add(exitG3);
+
+        ImageView exitG5 = new ImageView();
+        exitG5.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
+        exitG5.setRotate(180);
+        exitG5.setFitHeight(65);
+        exitG5.setFitWidth(65);
+        exitG5.setLayoutX(150+65*5);
+        exitG5.setLayoutY(100+65*7);
+        board.getChildren().add(exitG5);
+    }
+
+    //can create a image for one tile, given the tile name and its location
+    class Tile extends ImageView {
+        double x,y;
+        String tileName;
+        Viewer viewer;
+        Tile(String tileName, double x, double y){
+            this.x = x;
+            this.y = y;
+            this.tileName=tileName;
+            this.setImage(new Image(Viewer.class.getResource(URI_BASE+tileName+".png").toString()));
+            this.setFitHeight(65);
+            this.setFitWidth(65);
+            this.setLayoutX(x);
+            this.setLayoutY(y);
+            this.toFront();
+
+        }
+    }
+
+    //can create a draggable tile, add more functions based on Tile
+    class DraggableTile extends Tile {
+        private double x,y;
+        private double mouseX, mouseY;
+        private Viewer viewer;
+        private int rotate=0;
+        String gridName = "__";
+
+        DraggableTile(String tileName, double x, double y, Viewer viewer){
+            super(tileName,x,y);
+            this.x = x;
+            this.y = y;
+            this.viewer=viewer;
+
+            this.setOnScroll(event -> {
+                this.rotate();
+            });
+            this.setOnMousePressed(event -> {
+                this.mouseX = event.getSceneX();
+                this.mouseY = event.getSceneY();
+                this.x = super.getLayoutX();
+                this.y = super.getLayoutY();
+                this.toFront();
+                stringShow.getChildren().clear();
+                alert.getChildren().clear();
+            });
+            this.setOnMouseDragged(event -> {
+                this.setLayoutX(this.x+ event.getSceneX() - mouseX);
+                this.setLayoutY(this.y+  event.getSceneY() - mouseY);
+            });
+            this.setOnMouseReleased(event -> {  //fit the tile into the nearest grid, if not on board, back to original place
+                double xFitted = nearestGrid(this.getLayoutX(),this.getLayoutY())[0];
+                double yFitted = nearestGrid(this.getLayoutX(),this.getLayoutY())[1];
+                this.setLayoutX(xFitted);
+                this.setLayoutY(yFitted);
+
+                double theX = this.getLayoutX();
+                double theY = this.getLayoutY();
+                double a=150;
+                double b=100;
+                double min = 65*65*2;
+
+                for(String key:theBoardGrid().keySet()){
+                    int gridX = theBoardGrid().get(key)[0];
+                    int gridY = theBoardGrid().get(key)[1];
+                    double xSquare = (theX-gridX)*(theX-gridX);
+                    double ySquare = (theY-gridY)*(theY-gridY);
+                    if(xSquare+ySquare<min){
+                        a = gridX;
+                        b = gridY;
+                        min = xSquare+ySquare;
+                        gridName=key;
+                    }
+                }
+                if(min<65*65*2){
+                    this.setLayoutX(a);
+                    this.setLayoutY(b);
+                }else {
+                    this.setLayoutX(x);
+                    this.setLayoutY(y);
+                }
+                lockOthers();
+            });
+        }
+
+        //this function only for special tiles
+        //when clicked one tile, make other special tiles non-clickable
+        void lockOthers(){
+            if(this.tileName.substring(0,1).equals("S")){
+                if(specialMoved==null){
+                    specialMoved=this;
+                    special.getChildren().add(this);
+                    tiles.getChildren().remove(specialTiles);
+                    specialPictures.getChildren().clear();
+                    for(ImageView imageView:specialImages(this)){
+                        specialPictures.getChildren().add(imageView);
+                    }
+                    special.getChildren().add(specialPictures);
+                }
+
+            }
+        }
+
+
+        String getPlacementString(){
+            return tileName+gridName+rotate/90;
+        }
+
+        void rotate(){
+            rotate=rotate+90;
+            if(rotate<=270){
+                this.setRotate(rotate);
+            }else if(rotate<=630){
+                this.setRotate(0);
+                this.setScaleX(-1);
+                this.setRotate(rotate-360);
+            }else {
+                rotate=0;
+                this.setRotate(rotate);
+                this.setScaleX(1);
+            }
+        }
+
+        //show a red frame around the tile, disappear when click again
+        void alertError(){
+            Rectangle up = new Rectangle();
+            Rectangle down = new Rectangle();
+            Rectangle left = new Rectangle();
+            Rectangle right = new Rectangle();
+            Rectangle[] allRec = {up,down,left,right};
+            for(Rectangle rec:allRec){
+                rec.setFill(RED);
+            }
+            up.setWidth(75);
+            up.setHeight(5);
+            up.setX(this.getLayoutX()-5);
+            up.setY(this.getLayoutY()-5);
+            down.setWidth(75);
+            down.setHeight(5);
+            down.setX(this.getLayoutX()-5);
+            down.setY(this.getLayoutY()+65);
+            left.setWidth(5);
+            left.setHeight(75);
+            left.setX(this.getLayoutX()-5);
+            left.setY(this.getLayoutY()-5);
+            right.setWidth(5);
+            right.setHeight(75);
+            right.setX(this.getLayoutX()+65);
+            right.setY(this.getLayoutY()-5);
+
+            alert.getChildren().addAll(up,down,left,right);
+        }
+
+        //can only use on special tiles
+        //make the tile back to its original place
+        void backToOrigin(){
+            int i = Integer.parseInt(this.tileName.substring(1,2));
+            if(i<3){
+                this.setLayoutX(700+i*75);
+                this.setLayoutY(150);
+            }else {
+                this.setLayoutX(700+(i-3)*75);
+                this.setLayoutY(150+75);
+            }
+            this.setRotate(0);
+            this.setScaleX(1);
+            specialMoved=null;
+        }
+
+    }
+
+    //get the location of the nearest grid
+    double[] nearestGrid(double x, double y){
+        double[] nearest = new double[2];
+        double min = 65*65*2;
+        for(int[] location:gridLocation()){
+            double xSquare = (x-location[0])*(x-location[0]);
+            double ySquare = (y-location[1])*(y-location[1]);
+            if(xSquare+ySquare<min){
+                nearest[0] = location[0];
+                nearest[1] = location[1];
+                min = xSquare+ySquare;
+            }
+        }
+        if(min>=65*65*2){
+            nearest[0] = x;
+            nearest[1] = y;
+        }
+        return nearest;
+    }
+
+    //a list record all grids' location
+    int[][] gridLocation(){
+        int[][] list = new int[49][2];
+        int count = 0;
+        for(int i=0; i<7; i++){
+            for(int m=0; m<7; m++){
+                list[count][0]=150+m*65;
+                list[count][1]=100+i*65;
+                count++;
+            }
+        }
+        return list;
+    }
+
+    //a map record all grids' name and corresponding location
+    HashMap<String,int[]> theBoardGrid(){
+        HashMap<String,int[]> locations = new HashMap<>();
+        int[][] locationValue = gridLocation();
+        String[] locationString = Board.grid;
+        for(int i=0; i<49; i++){
+            locations.put(locationString[i],locationValue[i]);
+        }
+        return locations;
+    }
+
+    //help to build the board
+    class Grid extends Rectangle {
+        double x,y;
+        double size;
+        public Grid(double x, double y, double size){
+            this.x=x;
+            this.y=y;
+            this.size=size;
+            this.setWidth(size);
+            this.setHeight(size);
+            this.setLayoutX(x);
+            this.setLayoutY(y);
+            this.setFill(BEIGE);
+            this.setStroke(BLACK);
+        }
     }
 
     /**
+     * this method is for viewer mode
      * Create a basic text field for input and a refresh button.
      */
-    private void makeControls() {
-        Label label1 = new Label("Placement:");
-        textField = new TextField();
-        textField.setPrefWidth(300);
-        Button button = new Button("Refresh");
-        button.setOnAction(e -> {
+    private void inputArea() {
+
+        Label label1 = new Label("Placement String:");
+        TextField textField = new TextField();
+        textField.setPrefWidth(100);
+        textField.setPrefColumnCount(3);
+        Button button1 = new Button("Make Placement");
+        button1.setOnAction(e -> {
             makePlacement(textField.getText());
             textField.clear();
         });
+        Button button2 = new Button("Clear");
+        button2.setOnAction(e ->{
+            placementGroup.getChildren().clear();
+
+        });
+        button2.setLayoutX(880);
+        button2.setLayoutY(180);
+
+
         HBox hb = new HBox();
-        hb.getChildren().addAll(label1, textField, button);
+        hb.getChildren().addAll(label1, textField, button1);
         hb.setSpacing(10);
-        hb.setLayoutX(130);
-        hb.setLayoutY(VIEWER_HEIGHT - 50);
+        hb.setLayoutX(660);
+        hb.setLayoutY(150);
+
         controls.getChildren().add(hb);
+        controls.getChildren().add(button2);
     }
 
-    @Override
-    public void start(Stage primaryStage) throws Exception {
-        primaryStage.setTitle("StepsGame Viewer");
-        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
 
-        root.getChildren().add(controls);
+    /**
+     * Draw a placement in the window, removing any previously drawn one
+     *
+     * @param placement A valid placement string
+     */
+    void makePlacement(String placement) {
+        if(!RailroadInk.isBoardStringWellFormed(placement)){
+            throw new IllegalArgumentException("Illegal Board String");
+        }
+        for(int i=0; i<placement.length(); i+=5){
 
-        makeControls();
+            String tile = placement.substring(i,i+2);
+            int rowPosition = (placement.substring(i+2,i+3).hashCode()-65)*65+100;
+            int colPosition = Integer.parseInt(placement.substring(i+3,i+4))*65+150;
+            int orientation = Integer.parseInt(placement.substring(i+4,i+5));
+            int angle;
+            if(orientation<4){
+                angle = orientation*90;
+            }else {
+                angle = (orientation-4)*90;
+            }
 
-        primaryStage.setScene(scene);
-        primaryStage.show();
+            ImageView img = new ImageView();
+            img.setImage(new Image(Viewer.class.getResource(URI_BASE+tile+".png").toString()));
+            img.setRotate(angle);
+            if(orientation>=4){
+                img.setScaleX(-1);
+            }
+            img.setFitWidth(65);
+            img.setFitHeight(65);
+            img.setPreserveRatio(true);
+            img.setSmooth(true);
+            HBox hBox = new HBox();
+            hBox.getChildren().add(img);
+            placementGroup.getChildren().add(hBox);
+            hBox.setLayoutX(colPosition);
+            hBox.setLayoutY(rowPosition);
+        }
     }
+
 }
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer$Tile.class
Only in comp1110-ass2/src/comp1110/ass2: MultiplePlayers.class
Only in comp1110-ass2/src/comp1110/ass2: MultiplePlayers$DraggableTile.class
Only in comp1110-ass2/src/comp1110/ass2: MultiplePlayers$Grid.class
Only in comp1110-ass2/src/comp1110/ass2: MultiplePlayers.java
Only in comp1110-ass2/src/comp1110/ass2: MultiplePlayers$Tile.class
Only in comp1110-ass2/src/comp1110/ass2: RailroadInk.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/RailroadInk.java comp1110-ass2/src/comp1110/ass2/RailroadInk.java
--- ../master/comp1110-ass2/src/comp1110/ass2/RailroadInk.java	2019-05-24 13:59:04.556397359 +1000
+++ comp1110-ass2/src/comp1110/ass2/RailroadInk.java	2019-05-24 17:08:23.811561206 +1000
@@ -1,6 +1,11 @@
 package comp1110.ass2;
 
+import comp1110.ass2.gui.Board;
+
+import java.util.*;
+
 public class RailroadInk {
+
     /**
      * Determine whether a tile placement string is well-formed:
      * - it consists of exactly 5 characters;
@@ -10,26 +15,78 @@
      * - the fourth character represents the placement column 0-6
      * - the fifth character represents the orientation 0-7
      *
+     * @author Elton Li
      * @param tilePlacementString a candidate tile placement string
      * @return true if the tile placement is well formed
      */
     public static boolean isTilePlacementWellFormed(String tilePlacementString) {
-        // FIXME Task 2: determine whether a tile placement is well-formed
-        return false;
+        if(tilePlacementString.length()!=5){
+            return false;
+        }else {
+            try {
+                char first = tilePlacementString.charAt(0);
+                int second = Integer.parseInt(tilePlacementString.substring(1,2));
+                String third = tilePlacementString.substring(2,3);
+                int fourth = Integer.parseInt(tilePlacementString.substring(3,4));
+                int fifth = Integer.parseInt(tilePlacementString.substring(4));
+
+                if(first=='A' || first=='S'){
+                    if(second<0 || second>5){
+                        return false;
+                    }
+                }else if(first=='B'){
+                    if(second<0 || second>2){
+                        return false;
+                    }
+                }else {
+                    return false;
+                }
+
+                if(third.hashCode()<65 || third.hashCode()>71){
+                    return false;
+                }
+
+                if(fourth<0 || fourth>6){
+                    return false;
+                }
+
+                if(fifth<0 || fifth>7){
+                    return false;
+                }
+            }catch (java.lang.NumberFormatException e){
+                return false;
+            }
+        }
+        return true;
     }
 
+
     /**
      * Determine whether a board string is well-formed:
      * - it consists of exactly N five-character tile placements (where N = 1 .. 31);
      * - each piece placement is well-formed
      * - no more than three special tiles are included
      *
+     * @author Elton Li
      * @param boardString a board string describing the placement of one or more pieces
      * @return true if the board string is well-formed
      */
     public static boolean isBoardStringWellFormed(String boardString) {
-        // FIXME Task 3: determine whether a board string is well-formed
-        return false;
+       if(boardString==null || boardString==""|| boardString.length()>155 || boardString.length()%5!=0){
+           return false;
+       }else {
+           int countSpecialTile = 0;
+           for(int i =0; i<boardString.length();i=i+5){
+               String tilePlacementString = boardString.substring(i,i+5);
+               if(!isTilePlacementWellFormed(tilePlacementString)){
+                   return false;
+               }
+               if(tilePlacementString.charAt(0)=='S'){
+                   countSpecialTile++;
+               }
+           }
+           return countSpecialTile<=3;
+       }
     }
 
 
@@ -42,13 +99,37 @@
      * invalid connection between highway and railway; and
      * areConnectedNeighbours("A0B30", "A3C23") would return false as these tiles are not neighbours.
      *
+     * @author Yinuo Zhang
      * @return true if the placements are connected neighbours
      */
     public static boolean areConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
-        // FIXME Task 5: determine whether neighbouring placements are connected
+
+        if(!Board.areNeighbors(tilePlacementStringA,tilePlacementStringB)){
+            return false;
+        }
+
+        String[] infoA = Board.rotatedTileInfo(tilePlacementStringA);
+        String[] infoB = Board.rotatedTileInfo(tilePlacementStringB);
+
+        int B_relativeTo_A = Board.relativePosition(tilePlacementStringA,tilePlacementStringB);
+
+        if(B_relativeTo_A==0){
+            return infoB[2].equals(infoA[0]) && !infoA[0].equals("Nothing");
+
+        }else if (B_relativeTo_A==1){
+            return infoB[3].equals(infoA[1]) && !infoA[1].equals("Nothing");
+
+        }else if (B_relativeTo_A==2){
+            return infoB[0].equals(infoA[2]) && !infoA[2].equals("Nothing");
+
+        }else if (B_relativeTo_A==3){
+            return infoB[1].equals(infoA[3]) && !infoA[3].equals("Nothing");
+
+        }
         return false;
     }
 
+
     /**
      * Given a well-formed board string representing an ordered list of placements,
      * determine whether the board string is valid.
@@ -62,14 +143,120 @@
      * - A tile may have one or more edges touching a blank edge of another tile;
      *   this is referred to as disconnected, but the placement is still legal.
      *
+     * @author Xinyu Kang
      * @param boardString a board string representing some placement sequence
      * @return true if placement sequence is valid
      */
     public static boolean isValidPlacementSequence(String boardString) {
-        // FIXME Task 6: determine whether the given placement sequence is valid
-        return false;
+
+        if(boardString.isEmpty()){
+            return false;
+        }
+
+        int listLength = boardString.length()/5;
+        String[] tilesPlacementList = new String[listLength];
+
+        int count = 0;  //count the number of tile placement string that already included
+        for (int i=0; i<boardString.length(); i=i+5){
+            tilesPlacementList[count] = boardString.substring(i,i+5);
+            count++;
+        }
+
+        if(!Board.isConnectedToExit(tilesPlacementList[0])){ //check whether 1st tile connected to exit
+            return false;
+        }
+
+        for(int index = 1; index<tilesPlacementList.length; index++) {
+            String[] previousPlacements = new String[index];
+            System.arraycopy(tilesPlacementList, 0, previousPlacements, 0, index);
+
+            if(Board.isOverlap(tilesPlacementList[index],boardString.substring(0,index*5))){
+                return false;
+            }else{
+                if(Board.isAtExit(tilesPlacementList[index])){
+                    if(!Board.hasConnectedNeighbors(tilesPlacementList[index],previousPlacements)){
+                        if(!Board.isConnectedToExit(tilesPlacementList[index])){
+                            return false;
+                        }
+                    }else {
+                        if(!Board.isConnectedToExit(tilesPlacementList[index])){
+                            int col = Integer.parseInt(tilesPlacementList[index].substring(3,4));
+                            char row = tilesPlacementList[index].charAt(2);
+                            String[] a = Board.rotatedTileInfo(tilesPlacementList[index]);
+                            String theEdge = "";
+                            if(col==0){
+                                theEdge=a[3];
+                            }else if(col==6){
+                                theEdge=a[1];
+                            }
+                            if(row=='A'){
+                                theEdge=a[0];
+                            }else if(row=='G'){
+                                theEdge=a[1];
+                            }
+                            if(theEdge!="Nothing"){
+                                return false;
+                            }
+                        }
+                    }
+                }else {
+                    if(!Board.hasConnectedNeighbors(tilesPlacementList[index],previousPlacements)){
+                        return false;
+                    }
+                }
+            }
+
+            HashMap<String,Integer> allNeighbors = new HashMap<>();
+            for(String s:tilesPlacementList){
+                if(s.equals(tilesPlacementList[index])){
+                    break;
+                }else {
+                    if(Board.areNeighbors(tilesPlacementList[index],s)){
+                        allNeighbors.put(s,Board.relativePosition(tilesPlacementList[index],s));
+                    }
+                }
+            }
+            String[] a = Board.rotatedTileInfo(tilesPlacementList[index]);
+            for(String placement:allNeighbors.keySet()){
+                String[] b = Board.rotatedTileInfo(placement);
+                switch (allNeighbors.get(placement)){
+                    case 0:
+                        if(a[0].equals("Highway") && b[2].equals("Railway")){
+                            return false;
+                        }else if( a[0].equals("Railway") && b[2].equals("Highway")){
+                            return false;
+                        }
+                        break;
+                    case 1:
+                        if(a[1].equals("Highway") && b[3].equals("Railway")){
+                            return false;
+                        }else if( a[1].equals("Railway") && b[3].equals("Highway")){
+                            return false;
+                        }
+                        break;
+                    case 2:
+                        if(a[2].equals("Highway") && b[0].equals("Railway")){
+                            return false;
+                        }else if( a[2].equals("Railway") && b[0].equals("Highway")){
+                            return false;
+                        }
+                        break;
+                    case 3:
+                        if(a[3].equals("Highway") && b[1].equals("Railway")){
+                            return false;
+                        }else if( a[3].equals("Railway") && b[1].equals("Highway")){
+                            return false;
+                        }
+                        break;
+                }
+            }
+
+        }
+        return true;
+
     }
 
+
     /**
      * Generate a random dice roll as a string of eight characters.
      * Dice A should be rolled three times, dice B should be rolled once.
@@ -77,12 +264,17 @@
      * Die B has faces numbered 0-2.
      * Each die roll is composed of a character 'A' or 'B' representing the dice,
      * followed by a digit character representing the face.
-     *
+     * @author Yinuo Zhang
      * @return a String representing the die roll e.g. A0A4A3B2
      */
     public static String generateDiceRoll() {
-        // FIXME Task 7: generate a dice roll
-        return "";
+        Random r = new Random();
+        int result = r.nextInt(6);
+        int result1 = r.nextInt(6);
+        int result2 = r.nextInt(6);
+        int result3 = r.nextInt(3);
+        String dice = "A" + Integer.toString(result) + "A" +  Integer.toString(result1) + "A" +  Integer.toString(result2) +"B" + Integer.toString(result3);
+        return dice;
     }
 
     /**
@@ -92,27 +284,224 @@
      * * Number of exits mapped
      * * Number of centre tiles used
      * * Number of dead ends in the network
-     *
+     * @author Yinuo Zhang
      * @param boardString a board string representing a completed game
      * @return integer (positive or negative) for score *not* considering longest rail/highway
      */
     public static int getBasicScore(String boardString) {
-        // FIXME Task 8: compute the basic score
-        return -1;
+        int score = Scoring.countConnectedExits(boardString) + Scoring.countTilesInCentre(boardString) + Scoring.countErrors(boardString);
+        return score;
     }
 
     /**
      * Given a valid boardString and a dice roll for the round,
      * return a String representing an ordered sequence of valid piece placements for the round.
+     * @author Xinyu Kang
      * @param boardString a board string representing the current state of the game as at the start of the round
      * @param diceRoll a String representing a dice roll for the round
      * @return a String representing an ordered sequence of valid piece placements for the current round
      * @see RailroadInk#generateDiceRoll()
      */
     public static String generateMove(String boardString, String diceRoll) {
-        // FIXME Task 10: generate a valid move
-        return null;
+        String tile1 = diceRoll.substring(0,2);
+        String tile2 = diceRoll.substring(2,4);
+        String tile3 = diceRoll.substring(4,6);
+        String tile4 = diceRoll.substring(6,8);
+        ArrayList<String[]> list = new ArrayList<>();
+        String[] a1 = {tile1,tile2,tile3,tile4};
+        String[] a2 = {tile1,tile2,tile4,tile3};
+        String[] a3 = {tile1,tile3,tile2,tile4};
+        String[] a4 = {tile1,tile3,tile4,tile2};
+        String[] a5 = {tile1,tile4,tile2,tile3};
+        String[] a6 = {tile1,tile4,tile3,tile2};
+        String[] b1 = {tile2,tile1,tile3,tile4};
+        String[] b2 = {tile2,tile1,tile4,tile3};
+        String[] b3 = {tile2,tile3,tile1,tile4};
+        String[] b4 = {tile2,tile3,tile4,tile1};
+        String[] b5 = {tile2,tile4,tile1,tile3};
+        String[] b6 = {tile2,tile4,tile3,tile1};
+        String[] c1 = {tile3,tile1,tile2,tile4};
+        String[] c2 = {tile3,tile1,tile4,tile2};
+        String[] c3 = {tile3,tile2,tile1,tile4};
+        String[] c4 = {tile3,tile2,tile4,tile1};
+        String[] c5 = {tile3,tile4,tile1,tile2};
+        String[] c6 = {tile3,tile4,tile2,tile1};
+        String[] d1 = {tile4,tile1,tile2,tile3};
+        String[] d2 = {tile4,tile1,tile3,tile2};
+        String[] d3 = {tile4,tile2,tile1,tile3};
+        String[] d4 = {tile4,tile2,tile3,tile1};
+        String[] d5 = {tile4,tile3,tile1,tile2};
+        String[] d6 = {tile4,tile3,tile2,tile1};
+        list.add(a1);
+        list.add(a2);
+        list.add(a3);
+        list.add(a4);
+        list.add(a5);
+        list.add(a6);
+        list.add(b1);
+        list.add(b2);
+        list.add(b3);
+        list.add(b4);
+        list.add(b5);
+        list.add(b6);
+        list.add(c1);
+        list.add(c2);
+        list.add(c3);
+        list.add(c4);
+        list.add(c5);
+        list.add(c6);
+        list.add(d1);
+        list.add(d2);
+        list.add(d3);
+        list.add(d4);
+        list.add(d5);
+        list.add(d6);
+
+        ArrayList<String> results = new ArrayList<>();
+        int maxLen = boardString.length();
+        String bestOne = "";
+        for(String[] s: list){
+            String k = onePossibility(boardString,s);
+            results.add(k);
+            if((k.length()-boardString.length())==20){
+                return k.substring(boardString.length());
+            }
+            if(k.length()>maxLen){
+                maxLen=k.length();
+                bestOne=k;
+            }
+
+        }
+        return bestOne.substring(boardString.length());
+
+        /*
+        // task 10 version 1 part one, @author Yinuo Zhang
+        String moves1 = generateMoves(boardString,diceRoll);
+        String moves2 = generateMoves(boardString,diceRoll.substring(6) + diceRoll.substring(0,6));
+        String moves3 = generateMoves(boardString,diceRoll.substring(4) + diceRoll.substring(0,4));
+        String moves4 = generateMoves(boardString,diceRoll.substring(2) + diceRoll.substring(0,2));
+        if (moves1.length() == 20){return moves1;} else if (moves2.length() == 20){return moves2;} else if (moves3.length() == 20){return moves3;} else if (moves4.length() == 20){return moves4;}
+        else if (moves2.length() > moves1.length() && moves2.length() >= moves3.length() && moves2.length() >= moves4.length()){return moves2;}
+        else if (moves3.length() > moves1.length() && moves3.length() >= moves2.length() && moves3.length() >= moves4.length()){return moves3;}
+        else if (moves4.length() > moves1.length() && moves4.length() >= moves2.length()){return moves4;}
+        return moves1;
+         */
+    }
+
+    /**
+     * @author Xinyu Kang
+     * @param boardString
+     * @param dices a list of dice rolling results i.e. {"A0","A0","A2","B1"}
+     * @return new boardString
+     */
+    public static String onePossibility(String boardString, String[] dices){
+        String moves1 = oneMove(boardString,dices[0]);
+        if(moves1.length()==boardString.length()){
+            return boardString;
+        }
+        String moves2 = oneMove(moves1,dices[1]);
+        if(moves2.length()==moves1.length()){
+            return moves1;
+        }
+        String moves3 = oneMove(moves2,dices[2]);
+        if (moves3.length()==moves2.length()){
+            return moves2;
+        }
+        String moves4 = oneMove(moves3,dices[3]);
+        return moves4;
+    }
+
+    /**
+     * @author Xinyu Kang
+     * @param boardString
+     * @param tileName
+     * @return a new boardString
+     */
+    public static String oneMove(String boardString, String tileName){
+        String[] a = {"A","B","C","D","E","F","G"};
+        String[] b = {"1","2","3","4","5","6","7"};
+        String[] c = {"0","1","2","3","4","5","6","7"};
+        String toReturn="";
+        for(String row:a){
+            if(toReturn.length()>=5){
+                break;
+            }
+            for(String col:b){
+                if(toReturn.length()>=5){
+                    break;
+                }
+                for(String ori:c){
+                    String place = tileName+row+col+ori;
+                    if(isBoardStringWellFormed(boardString+place) && isValidPlacementSequence(boardString+place)){
+                        //list.add(place);
+                        toReturn=place;
+                        break;
+                    }
+                }
+            }
+        }
+
+        String[] d = {"0","1","2","3","4","5"};
+        if(toReturn.isEmpty()){
+            for(String special:d){
+                if(toReturn.length()>=5){
+                    break;
+                }
+                for(String col:a){
+                    if(toReturn.length()>=5){
+                        break;
+                    }
+                    for(String row:b){
+                        if(toReturn.length()>=5){
+                            break;
+                        }
+                        for(String ori:c){
+                            String place = "S"+special+row+col+ori;
+                            if(isBoardStringWellFormed(boardString+place) && isValidPlacementSequence(boardString+place)){
+                                toReturn=place;
+                                break;
+                            }
+                        }
+                    }
+                }
+            }
+        }
+        return boardString+toReturn;
+    }
+
+/*
+
+    //task 10 version 1  part two , @author Yinuo Zhang
+    public static String generateMoves(String boardString, String diceRoll) {
+        String moves = "";
+        for (int i = 0; i <diceRoll.length(); i += 2){
+            String move = generateAMove(boardString,diceRoll.substring(i,i+2));
+            if(move != ""){
+                moves += move;
+                boardString += move; }}
+        System.out.println(moves);
+        return moves;
+    }
+
+    private static String generateAMove (String boardString, String diceRoll){
+        String place = "";
+        String[] a = {"A", "B", "C", "D", "E", "F", "G" };
+        String[] b = {"0", "1", "2", "3", "4", "5", "6" };
+        String[] c = {"0", "1", "2", "3", "4", "5", "6", "7" };
+        for (int x = 0; x<7; x++){
+            for (int y = 0; y<7; y++){
+                for (int z = 0; z<8; z++){ place += a[x] + b[y] + c[z]; }}}
+
+        for (int j = 0; j<place.length(); j += 3){
+            String move = diceRoll+ place.substring(j,j+3);
+            if(isValidPlacementSequence((boardString + move))){
+                return move;}}
+
+        return "";
     }
+ */
+
+
 
     /**
      * Given the current state of a game board, output an integer representing the sum of all the factors contributing
@@ -128,5 +517,6 @@
         // FIXME Task 12: compute the total score including bonus points
         return -1;
     }
+
 }
 
Only in comp1110-ass2/src/comp1110/ass2: Scoring.class
Only in comp1110-ass2/src/comp1110/ass2: Scoring.java
Only in comp1110-ass2/src/comp1110/ass2: Tiles.class
Only in comp1110-ass2/src/comp1110/ass2: Tiles.java
Only in comp1110-ass2/src: META-INF
Only in comp1110-ass2/tests/comp1110/ass2: IsAtExitTest.java
diff -ru -x .git ../master/comp1110-ass2/tests/comp1110/ass2/IsBoardStringWellFormedTest.java comp1110-ass2/tests/comp1110/ass2/IsBoardStringWellFormedTest.java
--- ../master/comp1110-ass2/tests/comp1110/ass2/IsBoardStringWellFormedTest.java	2019-05-24 13:59:05.152400943 +1000
+++ comp1110-ass2/tests/comp1110/ass2/IsBoardStringWellFormedTest.java	2019-05-24 17:08:25.539573531 +1000
@@ -34,7 +34,7 @@
     public void testIncomplete() {
         testTrivialCorrect();
         String incomplete = SampleGames.COMPLETED_GAMES[0].substring(0, 23);
-        assertFalse("Board string '" + incomplete + "'was incomplete, but passed", RailroadInk.isBoardStringWellFormed(incomplete));
+        assertFalse( "Board string '"+ incomplete + "'was incomplete, but passed", RailroadInk.isBoardStringWellFormed(incomplete));
     }
 
     @Test
Only in comp1110-ass2/tests/comp1110/ass2: IsConnectedToExitTest.java
Only in comp1110-ass2/tests/comp1110/ass2: RelativePositionTest.java
Only in comp1110-ass2/tests/comp1110/ass2: RotatedTileInfoTest.java
```
## Test log
```
--javac output--
----
JUnit version 4.12
...
Time: 0.054

OK (3 tests)

JUnit version 4.12
......
Time: 0.055

OK (6 tests)

JUnit version 4.12
.....
Time: 0.04

OK (5 tests)

JUnit version 4.12
.....
Time: 0.074

OK (5 tests)

JUnit version 4.12
....
Time: 0.116

OK (4 tests)

JUnit version 4.12
.Sample game A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11
score 24
Sample game A3A10A3A52A3G10B2F10S1B50A2B61A0C60A1B41B1A35A4A41A2B31A1C30B0D32A2C50A4E10A3D12B2B10A2F01A0G00A4D01B1A27S3B20A4C10A1D50A0F23B2G25A3E30A4E41
score 18
Sample game A2A30A0A43A3A50B2B50A4C50A3D50A2B43B0G12B0A14A2B33A0B11A4E50A3D61A2B21A3G52B1G45A3F52B2F41A3F33A1E40A1D40A3E32A3E27B0F10S0E12B1D17A4D01A1B61A0C43
score 21
Sample game A4A50A1F61A0B61S5F50B1F46A1F01S1F12A2F23A1E20B2D21A3D03A1C20A0B22B1A61A4D11A4G10B1G44A2G30A3C01A3C12B0B31A1B01A4B50B0C50A2F32A0E32A0E40A4D31B1D47A1B11
score 15
Sample game A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02
score 23
Sample game A4G10B2F10A4E10A0F20A3D17A0E22A2E31B1E44S0D42A3D23A4D31A2F30B1F42A1G30A0C42A0C57B0C22A2F03A1E02S5D01A0B22B0A50A4D51A3D61B2B53A0B30B2A31A4E60A3A41A0B03
score 23
Sample game A3A10B2A31A1B30A0F61A4A21B1B14A4A41A4D61S2A50A5A63A2B01A1C02B0G52S0B63A0E63A2E51A4D51B0C32A5D31A5C61A0E41S5D41B1D03A5B51A4G10A0C42B0G30A2F52A5F12B2F21A0F00
score 30
E...
Time: 0.079
There was 1 failure:
1) testSampleGames(comp1110.ass2.GetBasicScoreTest)
java.lang.AssertionError: Sample game including networks connecting [5, 4, 1, 1, 1] exits covering 5 centre squares with 7 errors: expected total score 26 but RailroadInk.getBasicScore returned total score: 30
	at org.junit.Assert.fail(Assert.java:88)
	at org.junit.Assert.assertTrue(Assert.java:41)
	at comp1110.ass2.GetBasicScoreTest.testSampleGames(GetBasicScoreTest.java:67)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:298)
	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:292)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.lang.Thread.run(Thread.java:834)

FAILURES!!!
Tests run: 4,  Failures: 1

JUnit version 4.12
.....
Time: 7.406

OK (5 tests)

JUnit version 4.12
.Sample game A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11
score -1
E.E
Time: 0.023
There were 2 failures:
1) testSampleGames(comp1110.ass2.GetAdvancedScoreTest)
java.lang.AssertionError: Sample game including networks connecting [7, 2] exits covering 7 centre squares with 11 errors longest railway 5 longest road 12: expected total score 41 but RailroadInk.getAdvancedScore returned total score: -1
	at org.junit.Assert.fail(Assert.java:88)
	at org.junit.Assert.assertTrue(Assert.java:41)
	at comp1110.ass2.GetAdvancedScoreTest.testSampleGames(GetAdvancedScoreTest.java:26)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:298)
	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:292)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.lang.Thread.run(Thread.java:834)
2) testFullGameExample(comp1110.ass2.GetAdvancedScoreTest)
java.lang.AssertionError: Sample game including networks connecting [6, 4] exits covering 6 centre squares with 5 errors longest railway 5 longest road 8: expected total score 46 but RailroadInk.getAdvancedScore returned total score: -1
	at org.junit.Assert.fail(Assert.java:88)
	at org.junit.Assert.assertTrue(Assert.java:41)
	at comp1110.ass2.GetAdvancedScoreTest.testFullGameExample(GetAdvancedScoreTest.java:16)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:298)
	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:292)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.lang.Thread.run(Thread.java:834)

FAILURES!!!
Tests run: 2,  Failures: 2

```
