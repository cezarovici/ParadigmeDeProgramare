class StackNode:
    def __init__(self,data):
        self.data = data
        self.next = None


class Stack:
    def __init__(self):
        self.top = None
        
    def push(self, data):
        new_node = StackNode(data)
        new_node.next = self.top
        self.top = new_node
        
    def pop(self):
        if self.top is None:
            return None
        else:
            popped_node = self.top
            self.top = self.top.next
            return popped_node.data
        
    def peek(self):
        if self.top is None:
            return None
        else:
            return self.top.data
        
    def is_empty(self):
        return self.top is None


def infix_to_postfix(expression):
    precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}
    
    postfix = []
    stack = Stack()

    for symbol in expression:
        if symbol.isalpha() or symbol.isdigit():
            postfix.append(symbol)
       
        elif symbol in precedence:
            while (not stack.is_empty() and stack.peek() != '(' and
                   precedence[symbol] <= precedence[stack.peek()]):
                postfix.append(stack.pop())
            stack.push(symbol)
        
        elif symbol == '(':
            stack.push(symbol)
        
        elif symbol == ')':
            while (not stack.is_empty() and stack.peek() != '('):
                postfix.append(stack.pop())
        
            if not stack.is_empty() and stack.peek() == '(':
                stack.pop()
    
    while not stack.is_empty():
        postfix.append(stack.pop())
    
        
    return ''.join(postfix)



def evalPolish(polish):
    stack = Stack()
    precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}


    for symbol in polish:
        print(stack.peek())
        print(polish)
        if symbol.isdigit():
            stack.push(symbol)
            continue
        
        if symbol == ' ':
            continue

        if symbol in precedence:
            op1 = int(stack.pop())
            op2 = int(stack.pop())

            if symbol == '+':
                stack.push(op1+op2)

            if symbol == '-':
                stack.push(op2-op1)
           
            if symbol == '*':
                stack.push(op1*op2)
           
            if symbol == '/':
                stack.push(op2/op1)
 
            if symbol == '^':
                stack.push(op2^op1)

    return stack.pop()


print((evalPolish(infix_to_postfix('3 * (2 + 4) / (1 + 5)'))))