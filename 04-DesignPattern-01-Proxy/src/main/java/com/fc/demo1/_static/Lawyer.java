package com.fc.demo1._static;
//代理类（律师），代理当事人
public class Lawyer implements Lawsuit{
   //包含一个真实对象（被代理对象）
    private final Lawsuit lawsuit;

    public Lawyer(Lawsuit lawsuit) {
        this.lawsuit = lawsuit;
    }


    @Override
    public void submit() {
        this.gatherEvidence();

        lawsuit.submit();
    }

    @Override
    public void defend() {
        lawsuit.defend();

        this.compareNotes();
    }

    //增强方法就是代理对真实对象的方法的一个增强
    //搜集证据
    private void gatherEvidence(){
        System.out.println("搜集证据");
    }

    //交换意见
    private void compareNotes(){
        System.out.println("交换意见，如果被告不服，继续上诉");
    }
}
