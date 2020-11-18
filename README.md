# cycleBilling [Pricing Module]
The module to be developed is a pricing engine for a cycle. A cycle can be thought of as high level components -

frame, 
handle bar with brakes, 
seating, 
wheels, 
chain assembly.

Each of the above high level components will have parts, for instance, a wheel has spokes, rim, tube, tyre.

The pricing module should calculates the price of the cycle given its configuration. For example, price a cycle with tubeless tyres, steel frame, 4 gears. The pricing of the parts is time sensitive, means the cost of a tyre will change with time and the module should support this. A tyre can cost 200Rs from Jan 2016 - Nov 2016, and its price can change to Rs 230 from Dec 2016 onwards.
Unit testing using Junit.

Calculates Pricing for 1000 cycles using multithread and blocking queue using a maximum of 10 thread
