	.file	"tictac.c"
	.text
	.globl	_kasittely
	.def	_kasittely;	.scl	2;	.type	32;	.endef
_kasittely:
LFB10:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$20, %esp
	movl	12(%ebp), %eax
	movb	%al, -20(%ebp)
	movl	$1, -4(%ebp)
	movb	$1, -5(%ebp)
	jmp	L2
L7:
	movsbl	-20(%ebp), %edx
	movsbl	-5(%ebp), %eax
	leal	(%edx,%eax), %ecx
	movl	$1717986919, %edx
	movl	%ecx, %eax
	imull	%edx
	sarl	$2, %edx
	movl	%ecx, %eax
	sarl	$31, %eax
	subl	%eax, %edx
	movl	%edx, %eax
	sall	$2, %eax
	addl	%edx, %eax
	addl	%eax, %eax
	subl	%eax, %ecx
	movl	%ecx, %edx
	testl	%edx, %edx
	je	L28
	movsbl	-20(%ebp), %edx
	movsbl	-5(%ebp), %eax
	addl	%edx, %eax
	movl	%eax, %edx
	movl	8(%ebp), %eax
	addl	%edx, %eax
	movzbl	(%eax), %edx
	movsbl	-20(%ebp), %ecx
	movl	8(%ebp), %eax
	addl	%ecx, %eax
	movzbl	(%eax), %eax
	cmpb	%al, %dl
	jne	L5
	addl	$1, -4(%ebp)
L5:
	movzbl	-5(%ebp), %eax
	addl	$1, %eax
	movb	%al, -5(%ebp)
L2:
	movsbl	-5(%ebp), %eax
	movl	16(%ebp), %edx
	addl	$1, %edx
	cmpl	%edx, %eax
	jl	L7
	jmp	L6
L28:
	nop
L6:
	movl	-4(%ebp), %eax
	cmpl	16(%ebp), %eax
	jne	L8
	movl	$1, %eax
	jmp	L9
L8:
	movl	$1, -4(%ebp)
	movb	$1, -5(%ebp)
	jmp	L10
L15:
	movsbl	-20(%ebp), %ecx
	movsbl	-5(%ebp), %edx
	movl	%edx, %eax
	sall	$2, %eax
	addl	%edx, %eax
	addl	%eax, %eax
	addl	%ecx, %eax
	cmpl	$99, %eax
	jg	L29
	movsbl	-20(%ebp), %ecx
	movsbl	-5(%ebp), %edx
	movl	%edx, %eax
	sall	$2, %eax
	addl	%edx, %eax
	addl	%eax, %eax
	addl	%ecx, %eax
	movl	%eax, %edx
	movl	8(%ebp), %eax
	addl	%edx, %eax
	movzbl	(%eax), %edx
	movsbl	-20(%ebp), %ecx
	movl	8(%ebp), %eax
	addl	%ecx, %eax
	movzbl	(%eax), %eax
	cmpb	%al, %dl
	jne	L13
	addl	$1, -4(%ebp)
L13:
	movzbl	-5(%ebp), %eax
	addl	$1, %eax
	movb	%al, -5(%ebp)
L10:
	movsbl	-5(%ebp), %eax
	movl	16(%ebp), %edx
	addl	$1, %edx
	cmpl	%edx, %eax
	jl	L15
	jmp	L14
L29:
	nop
L14:
	movl	-4(%ebp), %eax
	cmpl	16(%ebp), %eax
	jne	L16
	movl	$1, %eax
	jmp	L9
L16:
	movl	$1, -4(%ebp)
	movzbl	-20(%ebp), %ecx
	movsbw	%cl, %ax
	imull	$103, %eax, %eax
	shrw	$8, %ax
	movl	%eax, %edx
	sarb	$2, %dl
	movl	%ecx, %eax
	sarb	$7, %al
	subl	%eax, %edx
	movl	%edx, %eax
	sall	$2, %eax
	addl	%edx, %eax
	addl	%eax, %eax
	subl	%eax, %ecx
	movl	%ecx, %edx
	testb	%dl, %dl
	je	L17
	movb	$1, -5(%ebp)
	jmp	L18
L20:
	movsbl	-20(%ebp), %ecx
	movsbl	-5(%ebp), %edx
	movl	%edx, %eax
	sall	$3, %eax
	addl	%edx, %eax
	addl	%ecx, %eax
	movl	%eax, %edx
	movl	8(%ebp), %eax
	addl	%edx, %eax
	movzbl	(%eax), %edx
	movsbl	-20(%ebp), %ecx
	movl	8(%ebp), %eax
	addl	%ecx, %eax
	movzbl	(%eax), %eax
	cmpb	%al, %dl
	jne	L19
	addl	$1, -4(%ebp)
L19:
	movzbl	-5(%ebp), %eax
	addl	$1, %eax
	movb	%al, -5(%ebp)
L18:
	movsbl	-5(%ebp), %eax
	movl	16(%ebp), %edx
	addl	$1, %edx
	cmpl	%edx, %eax
	jl	L20
	movl	-4(%ebp), %eax
	cmpl	16(%ebp), %eax
	jne	L17
	movl	$1, %eax
	jmp	L9
L17:
	movl	$1, -4(%ebp)
	movb	$1, -5(%ebp)
	jmp	L21
L26:
	movsbl	-20(%ebp), %eax
	leal	1(%eax), %ecx
	movl	$1717986919, %edx
	movl	%ecx, %eax
	imull	%edx
	sarl	$2, %edx
	movl	%ecx, %eax
	sarl	$31, %eax
	subl	%eax, %edx
	movl	%edx, %eax
	sall	$2, %eax
	addl	%edx, %eax
	addl	%eax, %eax
	subl	%eax, %ecx
	movl	%ecx, %edx
	testl	%edx, %edx
	je	L30
	movsbl	-20(%ebp), %ecx
	movsbl	-5(%ebp), %edx
	movl	%edx, %eax
	sall	$2, %eax
	addl	%edx, %eax
	addl	%eax, %eax
	addl	%edx, %eax
	addl	%ecx, %eax
	movl	%eax, %edx
	movl	8(%ebp), %eax
	addl	%edx, %eax
	movzbl	(%eax), %edx
	movsbl	-20(%ebp), %ecx
	movl	8(%ebp), %eax
	addl	%ecx, %eax
	movzbl	(%eax), %eax
	cmpb	%al, %dl
	jne	L24
	addl	$1, -4(%ebp)
L24:
	movzbl	-5(%ebp), %eax
	addl	$1, %eax
	movb	%al, -5(%ebp)
L21:
	movsbl	-5(%ebp), %eax
	movl	16(%ebp), %edx
	addl	$1, %edx
	cmpl	%edx, %eax
	jl	L26
	jmp	L25
L30:
	nop
L25:
	movl	-4(%ebp), %eax
	cmpl	16(%ebp), %eax
	jne	L27
	movl	$1, %eax
	jmp	L9
L27:
	movl	$0, %eax
L9:
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE10:
	.globl	_tictactoe_check
	.def	_tictactoe_check;	.scl	2;	.type	32;	.endef
_tictactoe_check:
LFB11:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$28, %esp
	movl	$0, -8(%ebp)
	movl	$0, -12(%ebp)
	movb	$0, -1(%ebp)
	jmp	L32
L35:
	movsbl	-1(%ebp), %edx
	movl	8(%ebp), %eax
	addl	%edx, %eax
	movzbl	(%eax), %eax
	cmpb	$1, %al
	jne	L33
	cmpl	$0, -8(%ebp)
	jne	L33
	movsbl	-1(%ebp), %eax
	movl	12(%ebp), %edx
	movl	%edx, 8(%esp)
	movl	%eax, 4(%esp)
	movl	8(%ebp), %eax
	movl	%eax, (%esp)
	call	_kasittely
	cmpl	$1, %eax
	jne	L33
	movl	$1, -8(%ebp)
	jmp	L34
L33:
	movsbl	-1(%ebp), %edx
	movl	8(%ebp), %eax
	addl	%edx, %eax
	movzbl	(%eax), %eax
	cmpb	$2, %al
	jne	L34
	cmpl	$0, -12(%ebp)
	jne	L34
	movsbl	-1(%ebp), %eax
	movl	12(%ebp), %edx
	movl	%edx, 8(%esp)
	movl	%eax, 4(%esp)
	movl	8(%ebp), %eax
	movl	%eax, (%esp)
	call	_kasittely
	cmpl	$1, %eax
	jne	L34
	movl	$1, -12(%ebp)
	nop
L34:
	movzbl	-1(%ebp), %eax
	addl	$1, %eax
	movb	%al, -1(%ebp)
L32:
	cmpb	$99, -1(%ebp)
	jle	L35
	cmpl	$1, -8(%ebp)
	jne	L36
	cmpl	$1, -12(%ebp)
	je	L37
L36:
	cmpl	$0, -8(%ebp)
	jne	L38
	cmpl	$0, -12(%ebp)
	jne	L38
L37:
	movl	$0, %eax
	jmp	L39
L38:
	cmpl	$1, -8(%ebp)
	jne	L40
	movl	$1, %eax
	jmp	L39
L40:
	movl	$2, %eax
L39:
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE11:
	.ident	"GCC: (MinGW.org GCC-6.3.0-1) 6.3.0"
