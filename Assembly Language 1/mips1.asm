# AL1 - mips1.asm
# Joao Paulo Dos Santos Ferreira
# CSIT 230 - Computer Systems
# Dr. George Antoniou
# November 8, 2019

# The following program adds the numbers 1, 2, 3, 4, 5
# using [li], [add] and different registers

	.text
	.globl main
main:
	# loads the each value in a different register
	li	$t0, 1
	li	$t1, 2
	li	$t2, 3
	li	$t3, 4
	li	$t4, 5
	
	# adds the values in the registers one at a time
	add	$t5, $t0, $t1
	add	$t5, $t5, $t2
	add	$t5, $t5, $t3
	add	$t5, $t5, $t4
	
	#ends the program
	li	$v0, 10
	syscall
