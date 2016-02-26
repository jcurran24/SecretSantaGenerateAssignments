Secret Santa Assignment Generator Drawing Program README File

Summary:

Provides 2 different implementations of algorithms that take in a array of Strings containing names of people in a secret santa drawing and assigns each donor to a different unique receiver.

Also provides Unit Tests and a program demonstrating that the algorithms function properly.

Instructions and Requirements for running tests.

1. Maven will need to be installed and your MAVEN_HOME and PATH variable will need to be setup on your system.
2. Change to the directoty of the SecretSantaGenerateAssignments.
3. Compile the code with the following command

mvn compile

4. Run all Unit tests with the following command
mvn test 

or run each individually with the following commands

mvn test -Dtest=SecretSantaAssignmentGeneratorImplTest

or 

mvn test -Dtest=SecretSantaAssignmentGeneratorImplTwoTest


Instructions for running the Secret Santa drawing program:

1. Start the program with the following maven command from the command line at the root of the SecretSantaGenerateAssignments project directory

mvn exec:java -Dexec.mainClass="com.gohealth.secretsanta.main.SecretSantaDrawing"

2. At the prompt for the names of participants in the secret santa drawing, enter a list of at least 4 or more unique names each separated with a comma.
If you wish to exit the program enter Q to quit.  Any other input is invalid and will result in re-executing this step until proper input is entered or Q is
is entered. 

3. Select the number of the algorithm selected.  Either enter 1 or 2.  If you wish to exit the program enter Q to quit.  Any other input is invalid and will
result in re-executing this step until proper input is entered or Q is entered.

If options 1 or 2 were selected in step 3, the program will then display the list of participants in the drawing followed by a list of assignments mapped to each donor in the same order as the list of donors.  
 
Summary of algorithm choices available: 
   - Algorithm 1:
     Uses a random number generator to generate assignments for each    
     person.  It is less efficient than algorithm 2 as for each donor, multiple   
     times an invalid recipient could be randomly selected in a loop each time   
     until a valid recipient is finally selected. The expected worst case run time 
     is O(nLOGn).    
   
   - Algorithm 2:
     Selects the first valid recipient from a list of recipients and 
     removes the assigned recipient from the list.  For each donor, the first  
     or second recipient remaining in the list are likely to be selected making 
     this algorithm a lot more efficient than algorithm 1. The expected worst case  
     run time is expected to be O(n*2) or O(2n).
     




