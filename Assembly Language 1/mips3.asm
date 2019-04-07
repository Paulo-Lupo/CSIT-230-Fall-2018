# AL1 - mips3.asm
# Joao Paulo Dos Santos Ferreira
# CSIT 230 - Computer Systems
# Dr. George Antoniou
# November 8, 2019

# The following program adds the numbers 1, 2, 3, 4, 5
# using [li], [addi] and only the register [$t0]

	.text
	.globl main
main:
	#loads the first value in a register
	li	$t0, 1
	
	# adds imediately the remaining values one by one
	# stores the result in the same register
	addi	$t0, $t0, 2
	addi	$t0, $t0, 3
	addi	$t0, $t0, 4
	addi	$t0, $t0, 5
	
	#ends the program
	li	$v0, 10
	syscall
