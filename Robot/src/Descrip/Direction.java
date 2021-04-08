package Descrip;

public enum Direction {

    N() {
        public Direction getLeft() {
            return W;
        }

        public Direction getRight() {
            return E;
        }
    },
    E() {
        public Direction getLeft() {
            return N;
        }

        public Direction getRight() {
            return S;
        }
    },
    S() {
        public Direction getLeft() {
            return E;
        }

        public Direction getRight() {
            return W;
        }
    },
    W() {
        public Direction getLeft() {
            return S;
        }

        public Direction getRight() {
            return N;
        }
    };

    abstract Direction getLeft();
    abstract Direction getRight();
}
