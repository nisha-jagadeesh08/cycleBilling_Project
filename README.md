# cycleBilling [Pricing Module]
The module developed is a pricing engine for a cycle.

A cycle can be thought of as high level components -
frame, 
handle bar with brakes, 
seating, 
wheels, 
chain assembly.

Each of the above high level components will have parts, for instance, a wheel has spokes, rim, tube, tyre.

The pricing module should calculates the price of the cycle given its configuration. For example, price a cycle with tubeless tyres, steel frame, 4 gears. The pricing of the parts is time sensitive, means the cost of a tyre will change with time and the module should support this. A tyre can cost 200Rs from Jan 2016 - Nov 2016, and its price can change to Rs 230 from Dec 2016 onwards.
Unit testing using Junit.

Calculates Pricing for 1000 cycles using multithread and blocking queue using a maximum of 10 thread

Refer to "Design Document.docx" under master branch to get insight on the project implementation.
Refer to class diagram of above project in master branch : "Cycle_ClassDiagram.png"

Execution Details:
==================
1. Execute main() under src\com\PriceEngine\CycleScenario\ThreadImplemetation - to observe output of multi-thread implementation.
2. Execute method in src\com\PriceEngine\CycleScenario\CycleImplementationTest class - for performing unit testing using Junit 

On a side note, I would recommend running the Thread implementation part in IntelliJ IDEA as the project was implemented using IntelliJ IDEA,
I have defined colors  to identify different threads in the Main Class of Thread implementation as it is supported by IntelliJ IDEA.
Kindly ignore the constant if executed in a different IDE.
