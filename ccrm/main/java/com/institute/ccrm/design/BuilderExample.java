package com.institute.ccrm.design;

/**
 * Example demonstrating the Builder design pattern.
 */
public class BuilderExample {
    
    private String field1;
    private int field2;
    private boolean field3;
    
    private BuilderExample(Builder builder) {
        this.field1 = builder.field1;
        this.field2 = builder.field2;
        this.field3 = builder.field3;
    }
    
    public static class Builder {
        private String field1;
        private int field2;
        private boolean field3;
        
        public Builder setField1(String field1) {
            this.field1 = field1;
            return this;
        }
        
        public Builder setField2(int field2) {
            this.field2 = field2;
            return this;
        }
        
        public Builder setField3(boolean field3) {
            this.field3 = field3;
            return this;
        }
        
        public BuilderExample build() {
            return new BuilderExample(this);
        }
    }
    
    @Override
    public String toString() {
        return "BuilderExample{" +
               "field1='" + field1 + '\'' +
               ", field2=" + field2 +
               ", field3=" + field3 +
               '}';
    }
}
