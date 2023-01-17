	.file	"sqrt.c"
	.globl	_num
	.data
	.align 2
_num:
	.word	2345
	.globl	_res
	.bss
	.align 4
_res:
	.space 4
	.globl	_bit
	.data
	.align 4
_bit:
	.long	65536
	.def	___main;	.scl	2;	.type	32;	.endef
	.text
	.globl	_main
	.def	_main;	.scl	2;	.type	32;	.endef
_main:
LFB10:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	andl	$-16, %esp
	call	___main
	jmp	L2
L3:
	movl	_bit, %eax
	sarl	$2, %eax
	movl	%eax, _bit
L2:
	movzwl	_num, %eax
	movswl	%ax, %edx
	movl	_bit, %eax
	cmpl	%eax, %edx
	jl	L3
	jmp	L4
L7:
	movzwl	_num, %eax
	cwtl
	movl	_res, %ecx
	movl	_bit, %edx
	addl	%ecx, %edx
	cmpl	%edx, %eax
	jl	L5
	movzwl	_num, %eax
	movl	%eax, %edx
	movl	_res, %eax
	movl	%eax, %ecx
	movl	_bit, %eax
	addl	%ecx, %eax
	subl	%eax, %edx
	movl	%edx, %eax
	movw	%ax, _num
	movl	_res, %eax
	sarl	%eax
	movl	%eax, %edx
	movl	_bit, %eax
	addl	%edx, %eax
	movl	%eax, _res
	jmp	L6
L5:
	movl	_res, %eax
	sarl	%eax
	movl	%eax, _res
L6:
	movl	_bit, %eax
	sarl	$2, %eax
	movl	%eax, _bit
L4:
	movl	_bit, %eax
	testl	%eax, %eax
	jne	L7
	nop
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE10:
	.ident	"GCC: (MinGW.org GCC-6.3.0-1) 6.3.0"
