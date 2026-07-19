# Open/Closed Principle (OCP)

## Definition
A class should be open for extension but closed for modification.

- Open for extension   → you can add new behaviour
- Closed for modification → you don't touch existing, already-tested code to do it

New requirements should mean new code, not edited old code.

## Real Life Analogy
A power strip. When you want to plug in a new device, you don't rewire the strip.
You just plug in. The strip is closed for modification (internal wiring stays the same)
but open for extension (new devices can connect anytime).

## What the bad/ code does wrong
`PaymentService` has a growing if-else block inside processPayment():

    if type == "UPI"    → handle UPI
    if type == "CARD"   → handle Card
    if type == "WALLET" → handle Wallet

Every new payment method forces you to open and edit this class.
One typo in the new block can break UPI and Card flows that already worked.

## What the good/ code fixes

Introduced a `PaymentStrategy` interface as the fixed contract.
Each payment method is its own class implementing that interface.
`PaymentStrategyFactory` handles the decision of which strategy to build.
`PaymentService` just calls strategy.pay() — no if-else, never changes.

### Flow
