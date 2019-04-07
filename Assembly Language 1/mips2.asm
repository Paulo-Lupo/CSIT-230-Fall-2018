# AL1 - mips2.asm
# Joao Paulo Dos Santos Ferreira
# CSIT 230 - Computer Systems
# Dr. George Antoniou
# November 8, 2019

# The following program adds the numbers 1, 2, 3, 4, 5
# using [li], [addi] and different registers

	.text
	.globl main
main:
	#loads the first value in a register
	li	$t0, 1
	
	# adds imediately the remaining values one by one
	# stores each value in a different register
	addi	$t1, $t0, 2
	addi	$t2, $t1, 3
	addi	$t3, $t2, 4
	addi	$t4, $t3, 5
	
	#ends the program
	li	$v0, 10
	syscall
