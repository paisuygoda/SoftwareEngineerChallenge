To avoid confusion I use "merchants" for merchants (users of this system) and "users" for users of merchants (PayPay App users).

# Given Requirements

- Input
  - Billions per day
    - Which is 10k - 100k per sec
    - Considering massive sales such as Chinese new year sale, it might be safer to assume 1mil per sec
    - Assuming each logs are <1KB, it's <1GB write per sec.

- Output
  - Millions of merchants
    - Assume each merchants access metrics 1 - 10 per day
    - Depends on visual design but assume we have <10 metrics in a page
    - Which is <1k per sec access to DB

- Others
  - <1h delay
  - least downtime
  - store data in a long time

# Wanted Features
1. Register user purchases to database
2. Give access to metrics to merchants
  - Transition and detailed number of: 
    - General Info
      - Purchase
      - Users
      - Sales
      - Purchase per user
      - Sales per user
      - Sales per purchase
    - Composition Info
      - Users by gender or age
      - Purchase by gender or age
      - Sales by gender or age
      - Average purchase by gender or age
      - User-average sales by gender or age
      - Purchase-average sales by gender or age


# Future Extension
Merchants would want more metrics which PayPay cannot afford currently(I assumed so)
  - \# of just-looking user
  - \# of purchase per item
  - Inflow source （e.g. used coupon)
  - Purchases with other payment methods

Therefore I set additional requirement:

- Schema would change, and system should not suffer from it
