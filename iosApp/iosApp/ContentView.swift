import SwiftUI
import shared

struct ContentView: View {
    
    init() {
        let appearance = UINavigationBarAppearance()
        appearance.configureWithOpaqueBackground()
        appearance.backgroundColor = UIColor(Color(hex: 0xFF47_0038))
        appearance.titleTextAttributes = [.foregroundColor: UIColor.white]
        appearance.largeTitleTextAttributes = [.foregroundColor: UIColor.white]

        UINavigationBar.appearance().standardAppearance = appearance
        UINavigationBar.appearance().scrollEdgeAppearance = appearance
        UINavigationBar.appearance().compactAppearance = appearance
        let thumbImage = UIImage(systemName: "circle.fill")
        UISlider.appearance().setThumbImage(thumbImage, for: .normal)
    }
    
    
    var body: some View {
        NavigationView {
            ZStack {
                Color(hex: 0xFFEB_EFF6)
                    .ignoresSafeArea()

                VStack {
                    ScrollView {
                        VStack(spacing: 10) {
                            Image("img_workout")
                                .resizable()
                                .aspectRatio(1.0, contentMode: .fit)
                                .frame(
                                    maxWidth: UIScreen.main.bounds.width * 0.65
                                )
                                .clipped()
                            PlaceItemView()
                            TimeSelectorView()
                        }
                        .padding(.horizontal, 16)
                        .padding(.top, calculateTopPadding())
                    }

                    NavigationLink(destination: CustomWorkoutView()) {
                        MyButton(name: "Create")
                    }
                }
            }
            .navigationBarTitle("My Workout", displayMode: .inline)
        }
    }

    private func calculateTopPadding() -> CGFloat {
        return 20
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
