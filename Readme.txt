
The goal of the problem is
1. maximize customer satisfaction
2. maximize theater utilization

The algorithm follows the following rules:
 1. Customers that come first will be alloted seats in the middle rows.
 2. Each group will be allotted seat in a single row. If the group size is larger than number of seats in the row, the group is split.
 3. Fulfill as many requests as possible.
 4. After scanning all the rows, if the theater is not able to allocate consequent seats to a group, allocate the seats wherever available.
 5. If the number of requested seats are not available in the theater, inform the customer about insufficient seats.  

Assumptions:
1. The Theater cannot reserve seats for a group if the requested number of seats are greater than available seats.
   In that case the customers are informed about the insufficient number of available seats. 